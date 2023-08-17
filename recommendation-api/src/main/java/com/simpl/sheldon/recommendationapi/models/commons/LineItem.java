package com.simpl.sheldon.recommendationapi.models.commons;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LineItem {
    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("price")
    private int price;

    @JsonProperty("unit_price")
    private int unitPrice;

    @JsonProperty("taxable")
    private Boolean taxable;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("metadata")
    private LineItemMetadata metadata;
}
