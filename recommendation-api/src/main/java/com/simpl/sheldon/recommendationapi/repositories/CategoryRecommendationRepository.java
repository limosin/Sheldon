package com.simpl.sheldon.recommendationapi.repositories;

import com.simpl.sheldon.recommendationapi.models.dao.CategoryRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRecommendationRepository extends JpaRepository<CategoryRecommendation, Long> {
}
