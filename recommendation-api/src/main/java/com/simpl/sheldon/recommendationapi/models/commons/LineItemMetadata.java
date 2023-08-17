package com.simpl.sheldon.recommendationapi.models.commons;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LineItemMetadata {
    @JsonProperty("category")
    private String category;

    @JsonProperty("collections")
    private List<String> collections;

    @JsonProperty("compare_at_price")
    private String compareAtPrice;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("product_type")
    private String productType;

    @JsonProperty("product_url")
    private String productUrl;

    @JsonProperty("sku")
    private String sku;

    @JsonProperty("tags")
    private List<String> tags;

    @JsonProperty("variant__id")
    private Long variant_Id;

    @JsonProperty("variant_options")
    private List<VariantOption> variantOptions;

    @JsonProperty("vendor")
    private String vendor;
}
