package com.simpl.sheldon.recommendationapi.models.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.simpl.sheldon.recommendationapi.models.commons.LineItem;
import com.simpl.sheldon.recommendationapi.models.commons.Merchant;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComplRecommendRequest {
    @JsonProperty("currency")
    private String currency;

    @JsonProperty("line_items")
    private List<LineItem> lineItems;

    @JsonProperty("merchant_checkout_url")
    private String merchantCheckoutUrl;

    @JsonProperty("merchant_details")
    private Merchant merchant;

    @JsonProperty("shop_domain")
    private String shopDomain;

    @JsonProperty("taxes_included")
    private boolean taxesIncluded;

    @JsonProperty("total_discount")
    private int totalDiscount;

    @JsonProperty("total_item_price")
    private int totalItemPrice;

    @JsonProperty("total_price")
    private int totalPrice;

    @JsonProperty("total_tax")
    private int totalTax;
}
