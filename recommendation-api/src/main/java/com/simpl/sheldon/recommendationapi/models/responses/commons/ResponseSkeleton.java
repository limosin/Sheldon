package com.simpl.sheldon.recommendationapi.models.responses.commons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class ResponseSkeleton<T> {
    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("data")
    private T data;

    @JsonProperty("errors")
    private List<Error> errors;

    @JsonProperty("api_version")
    private String apiVersion;
}