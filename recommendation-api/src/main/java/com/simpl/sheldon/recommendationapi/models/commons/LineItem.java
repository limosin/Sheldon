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
    private long price;

    @JsonProperty("unit_price")
    private long unitPrice;

    @JsonProperty(value = "taxable", access = JsonProperty.Access.WRITE_ONLY)
    private Boolean taxable;

    @JsonProperty(value = "quantity", access = JsonProperty.Access.WRITE_ONLY)
    private int quantity;

    @JsonProperty("metadata")
    private LineItemMetadata metadata;
}
