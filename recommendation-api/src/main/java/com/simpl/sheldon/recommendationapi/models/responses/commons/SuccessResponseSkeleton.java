package com.simpl.sheldon.recommendationapi.models.responses.commons;

public class SuccessResponseSkeleton<T> extends ResponseSkeleton<T> {
    public SuccessResponseSkeleton(String apiVersion) {
        this.setSuccess(true);
        this.setErrors(null);
    }

    public SuccessResponseSkeleton(T data, String apiVersion) {
        this(apiVersion);
        this.setData(data);
    }
}
