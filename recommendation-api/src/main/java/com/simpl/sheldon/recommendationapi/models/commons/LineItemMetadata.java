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
    @JsonProperty(value = "category", access = JsonProperty.Access.WRITE_ONLY)
    private String category;

    @JsonProperty(value = "collections", access = JsonProperty.Access.WRITE_ONLY)
    private List<String> collections;

    @JsonProperty(value = "compare_at_price", access = JsonProperty.Access.WRITE_ONLY)
    private String compareAtPrice;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("product_type")
    private String productType;

    @JsonProperty("product_url")
    private String productUrl;

    @JsonProperty(value = "sku", access = JsonProperty.Access.WRITE_ONLY)
    private String sku;

    @JsonProperty(value = "tags", access = JsonProperty.Access.WRITE_ONLY)
    private List<String> tags;

    @JsonProperty("variant_id")
    private Long variant_Id;

    @JsonProperty("variant_options")
    private List<VariantOption> variantOptions;

    @JsonProperty("vendor")
    private String vendor;
}
