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
@Qualifier("complRecommenderServicev1")
public class ComplRecommenderServicev1 implements ComplRecommenderService {

    @Autowired
    private CatalogRepository catalogRepository;

    @Autowired
    private CategoryRecommendationRepository categoryRecommendationRepository;

    private static final Logger logger = LogManager.getLogger(ComplRecommenderServicev1.class);
    @Override
    public RecommendationResponseData getRecommendation(ComplRecommendRequest request, String requestId) {
        String merchantId = ComplRecommenderServicev1.getMerchantId(request, requestId);
        List<Long> variantIds = ComplRecommenderServicev1.getVariantId(request, requestId);
        List<String> antecedents = new ArrayList<>();
        for(Long varId: variantIds) {
            logger.info("Merchant ID: {}, Variant ID: {}", merchantId, varId);
            List<CatalogItem> catalogItem = catalogRepository.findAllByMerchantIdAndVariantId(merchantId, varId);
            logger.info("Catalog Item: {}", catalogItem);
            if(catalogItem.size() > 0) {
                antecedents.add(catalogItem.get(0).getCategoryColor());
            }
        }
        if (antecedents.size() == 0) {
            return new RecommendationResponseData();
        }
        List<CategoryRecommendation> consequents = categoryRecommendationRepository.findAllByAntecedent(antecedents.get(0));
        if (consequents.size() == 0) {
            return new RecommendationResponseData();
        }
        logger.info("Consequents: {}", consequents);
        List<CatalogItem> recommendedItems = new ArrayList<>();
        for (CategoryRecommendation consequent: consequents) {
            List<CatalogItem> items = catalogRepository.getByMerchantIdAndCategoryColor(merchantId, consequent.getConsequent());
            recommendedItems.addAll(items);
        }
        List<CatalogItem> filteredItems = this.getFilteredRecommendations(recommendedItems);
        List<LineItem> lineItems = filteredItems.stream().map(CatalogToLineItem::mapCatalogToLineItem).toList();
        RecommendationResponseData recommendationResponseData = new RecommendationResponseData();
        recommendationResponseData.setRecommendedItems(lineItems);
        return recommendationResponseData;
    }

    private List<CatalogItem> getFilteredRecommendations(List<CatalogItem> recommendedItems) {
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
