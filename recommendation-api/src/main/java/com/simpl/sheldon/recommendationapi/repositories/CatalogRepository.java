package com.simpl.sheldon.recommendationapi.repositories;

import com.simpl.sheldon.recommendationapi.models.dao.CatalogItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogRepository extends JpaRepository<CatalogItem, String> {

    CatalogItem findFirstByMerchantIdAndVariantId(String merchantId, Long variantId);

    List<CatalogItem> findFirst10ByMerchantIdAndVariantId(String merchantId, Long variantId);

    List<CatalogItem> findFirst500ByMerchantIdAndCategoryColor(String merchantId, String category);
}
