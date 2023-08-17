package com.simpl.sheldon.recommendationapi.models.responses.commons;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;

public class ErrorResponseSkeleton extends ResponseSkeleton<Object> {

    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    protected ErrorResponseSkeleton(String apiVersion) {
        this.setSuccess(false);
        this.setApiVersion(apiVersion);
    }

    public ErrorResponseSkeleton(List<Error> errors, String apiVersion) {
        this(apiVersion);
        this.setData(null);
        this.setErrors(errors);
    }

    public ErrorResponseSkeleton(Error error, String apiVersion) {
        this(apiVersion);
        List<Error> errors = List.of(error);
        this.setData(null);
        this.setErrors(errors);
    }

    @Override
    public String toString() {
        return mapper.valueToTree(this).toString();
    }
}
