package com.simpl.sheldon.recommendationapi.models.commons;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VariantOption {
    @JsonProperty("name")
    private String name;

    @JsonProperty("value")
    private String value;
}
