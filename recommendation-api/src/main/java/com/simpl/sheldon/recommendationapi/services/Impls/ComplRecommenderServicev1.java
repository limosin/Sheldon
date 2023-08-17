package com.simpl.sheldon.recommendationapi.services.Impls;

import com.simpl.sheldon.recommendationapi.models.requests.ComplRecommendRequest;
import com.simpl.sheldon.recommendationapi.models.responses.recommendation.RecommendationResponseData;
import com.simpl.sheldon.recommendationapi.services.ComplRecommenderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("complRecommenderServicev1")
public class ComplRecommenderServicev1 implements ComplRecommenderService {

    private static final Logger logger = LogManager.getLogger(ComplRecommenderServicev1.class);
    @Override
    public RecommendationResponseData getRecommendation(ComplRecommendRequest request) {
        return new RecommendationResponseData();
    }
}
