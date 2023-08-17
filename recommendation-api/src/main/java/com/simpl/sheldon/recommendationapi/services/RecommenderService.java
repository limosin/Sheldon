package com.simpl.sheldon.recommendationapi.services;

public interface RecommenderService<K, V> {
    public V getRecommendation(K request);
}
