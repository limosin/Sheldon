package com.simpl.sheldon.recommendationapi.models.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = CategoryRecommendation.tableName)
@Getter @Setter
@ToString
public class CategoryRecommendation {
    public static final String tableName = "product_recommendations";
    @Id
    @Column(name = "index", nullable = false)
    private Long index;

    @Column(name = "antecedent")
    private String antecedent;

    @Column(name = "consequent")
    private String consequent;

    @Column(name = "confidence")
    private float confidence;

    @Column(name = "lift")
    private float lift;

    @Column(name = "support")
    private float support;
}
