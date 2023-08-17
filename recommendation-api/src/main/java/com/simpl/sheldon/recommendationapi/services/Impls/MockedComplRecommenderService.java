package com.simpl.sheldon.recommendationapi.services.Impls;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simpl.sheldon.recommendationapi.models.commons.LineItem;
import com.simpl.sheldon.recommendationapi.models.requests.ComplRecommendRequest;
import com.simpl.sheldon.recommendationapi.models.responses.recommendation.RecommendationResponseData;
import com.simpl.sheldon.recommendationapi.services.ComplRecommenderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("mockedComplementaryRecommenderService")
public class MockedComplRecommenderService implements ComplRecommenderService {

    private static final Logger logger = LogManager.getLogger(MockedComplRecommenderService.class);

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public RecommendationResponseData getRecommendation(ComplRecommendRequest request) {
        String item = """
                    {
                        "description": "",
                        "discounts": [],
                        "metadata": {
                        "category": "",
                        "collections": [
                            "ADIDAS"
                        ],
                        "compare_at_price": "50",
                        "image_url": "https://cdn.shopify.com/s/files/1/0687/1449/6296/products/8072c8b5718306d4be25aac21836ce16.jpg?v=1669964100",
                        "product_id": 8032261931304,
                        "product_type": "ACCESSORIES",
                        "product_url": "https://checkout-staging-v2.myshopify.com/products/adidas-classic-backpack-legend-ink-multicolour?variant=44150932242728",
                        "sku": "AD-04\\r\\n-blue-OS",
                        "tags": [
                            "adidas",
                            "backpack",
                            "egnition-sample-data",
                            "please-ship-free",
                            "test-v2-tag"
                        ],
                        "variant_id": 44150932242728,
                        "variant_options": [
                            {
                            "name": "Size",
                            "value": "OS"
                            },
                            {
                            "name": "Color",
                            "value": "blue"
                            }
                        ],
                        "vendor": "ADIDAS"
                        },
                        "price": 4,
                        "quantity": 1,
                        "taxable": false,
                        "taxes": [],
                        "title": "ADIDAS | CLASSIC BACKPACK | LEGEND INK MULTICOLOUR",
                        "unit_price": 4
                    }
                """;
        LineItem lineItem;
        try {
            lineItem = mapper.readValue(item, LineItem.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        RecommendationResponseData response = new RecommendationResponseData();
        response.setRecommendedItems(List.of(lineItem));
        return response;
    }
}
