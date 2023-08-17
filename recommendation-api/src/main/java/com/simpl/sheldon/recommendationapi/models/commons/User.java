package com.simpl.sheldon.recommendationapi.models.commons;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("global_user_id")
    private String globalUserId;

    @JsonProperty("id")
    private String id;

    @JsonProperty("email")
    private String email;
}
