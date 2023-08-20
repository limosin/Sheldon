package com.simpl.sheldon.recommendationapi.services.Impls;

import com.simpl.sheldon.recommendationapi.models.commons.LineItem;
import com.simpl.sheldon.recommendationapi.models.dao.CatalogItem;
import com.simpl.sheldon.recommendationapi.models.dao.CategoryRecommendation;
import com.simpl.sheldon.recommendationapi.models.dto.CatalogToLineItem;
import com.simpl.sheldon.recommendationapi.models.requests.ComplRecommendRequest;
import com.simpl.sheldon.recommendationapi.models.responses.recommendation.RecommendationResponseData;
import com.simpl.sheldon.recommendationapi.repositories.CatalogRepository;
import com.simpl.sheldon.recommendationapi.repositories.CategoryRecommendationRepository;
import com.simpl.sheldon.recommendationapi.services.ComplRecommenderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Qualifier("ComplRecommenderServiceCross")
public class ComplRecommenderServiceCross implements ComplRecommenderService {

    @Autowired
    private CatalogRepository catalogRepository;

    @Autowired
    private CategoryRecommendationRepository categoryRecommendationRepository;

    private static final Logger logger = LogManager.getLogger(ComplRecommenderServiceCross.class);
    @Override
    public RecommendationResponseData getRecommendation(ComplRecommendRequest request, String requestId) {
        String merchantId = "9204a81b-efbf-473d-a593-27d6df307ce8";
//        List<Long> variantIds = ComplRecommenderServiceCross.getVariantId(request, requestId);
        List<Long> variantIds = List.of(40710975291435L);
        RecommendationResponseData recommendationResponseData = new RecommendationResponseData();
        recommendationResponseData.setOriginalItems(request.getLineItems());
        CatalogItem catalogItem = catalogRepository.findFirstByMerchantIdAndVariantId(merchantId, variantIds.get(0));
        if (catalogItem == null) {
            recommendationResponseData.setRecommendedItems(new ArrayList<>());
            return recommendationResponseData;
        }
        logger.info("Catalog Item: {}", catalogItem);
        List<CategoryRecommendation> consequents = categoryRecommendationRepository.findAllByAntecedentOrderByConfidenceDesc(catalogItem.getCategoryColor());
        if (consequents.size() == 0) {
            recommendationResponseData.setRecommendedItems(new ArrayList<>());
            return recommendationResponseData;
        }
        logger.info("Consequents: {}", consequents);
        List<CatalogItem> recommendedItems = new ArrayList<>();
        for (CategoryRecommendation consequent: consequents) {
            List<CatalogItem> items = catalogRepository.findFirst500ByMerchantIdAndCategoryColor(merchantId, consequent.getConsequent());
            recommendedItems.addAll(items);
        }
        logger.info("Recommended Items Count: {}", recommendedItems.size());
        List<CatalogItem> filteredItems = this.getFilteredRecommendations(recommendedItems, catalogItem);
        List<LineItem> lineItems = filteredItems.stream().map(CatalogToLineItem::mapCatalogToLineItem).toList();
        recommendationResponseData.setRecommendedItems(lineItems);
        return recommendationResponseData;
    }

    private List<CatalogItem> getFilteredRecommendations(List<CatalogItem> recommendedItems, CatalogItem catalogItem) {
        // Get only first 10 items
        if (recommendedItems.size() > 10) {
            return recommendedItems.subList(0, 10);
        }
        return recommendedItems;
    }

    private static List<Long> getVariantId(ComplRecommendRequest request, String requestId) {
        return request.getLineItems().stream().map(lineItem -> lineItem.getMetadata().getVariant_Id()).toList();
    }

    private static String getMerchantId(ComplRecommendRequest request, String requestId) {
        return request.getMerchant().getId();
    }
}
