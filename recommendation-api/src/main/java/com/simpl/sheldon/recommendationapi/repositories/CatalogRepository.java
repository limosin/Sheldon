package com.simpl.sheldon.recommendationapi.repositories;

import com.simpl.sheldon.recommendationapi.models.dao.CatalogItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogRepository extends JpaRepository<CatalogItem, String> {

    List<CatalogItem> findAllByMerchantIdAndVariantId(String merchantId, Long variantId);

    List<CatalogItem> getByMerchantIdAndCategoryColor(String merchantId, String category);
}
