package com.simpl.sheldon.recommendationapi.services;

import com.simpl.sheldon.recommendationapi.models.requests.ComplRecommendRequest;
import com.simpl.sheldon.recommendationapi.models.responses.recommendation.RecommendationResponseData;

public interface ComplRecommenderService extends RecommenderService<ComplRecommendRequest, RecommendationResponseData> {
}
