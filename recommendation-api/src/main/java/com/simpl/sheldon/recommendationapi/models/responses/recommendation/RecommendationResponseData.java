package com.simpl.sheldon.recommendationapi.models.responses.recommendation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.simpl.sheldon.recommendationapi.models.commons.LineItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecommendationResponseData {
    @JsonProperty("recommended_items")
    private List<LineItem> recommendedItems;
}
