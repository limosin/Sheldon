package com.simpl.sheldon.recommendationapi.models.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = CategoryRecommendation.tableName)
public class CategoryRecommendation {
    public static final String tableName = "product_recommendations";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "antecedent", columnDefinition = "json")
    private String antecedent;

    @Column(name = "consequent", columnDefinition = "json")
    private String consequent;

    @Column(name = "confidence")
    private float confidence;

    @Column(name = "lift")
    private float lift;

    @Column(name = "support")
    private float support;
}
