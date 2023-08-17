package com.simpl.sheldon.recommendationapi.models.responses.recommendation;

import com.simpl.sheldon.recommendationapi.models.responses.commons.SuccessResponseSkeleton;

public class RecommendationResponse extends SuccessResponseSkeleton<RecommendationResponseData> {
    private static final String apiVersion = "1.0.0";
    public RecommendationResponse(RecommendationResponseData data) {
        super(apiVersion);
        this.setData(data);
    }
}
