package com.simpl.sheldon.recommendationapi.models.responses.commons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {
    private String code;
    private String message;

    public Error(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
