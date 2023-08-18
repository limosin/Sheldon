package com.simpl.sheldon.recommendationapi.repositories;

import com.simpl.sheldon.recommendationapi.models.dao.CatalogItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends JpaRepository<CatalogItem, String> {
}
