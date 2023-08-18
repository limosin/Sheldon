package com.simpl.sheldon.recommendationapi.models.dao;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(
        name = CatalogItem.tableName,
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "catalog_id_pkey",
                        columnNames = "id")
        }
)
public class CatalogItem {
    public static final String tableName = "product_catalog";

    @Id
    @Column(name = "id", length = 100, nullable = false)
    private String id;

    @Column(name = "sku_id", length = 100)
    private String skuId;

    @Column(name = "order_id", length = 100)
    private String orderId;

    @Column(name = "merchant_id", nullable = false)
    private UUID merchantId;

    @Column(name = "variant_id", length = 100)
    private String variantId;

    @Column(name = "category", length = 100, columnDefinition = "varchar(100) default 'generic'")
    private String category;

    @Column(name = "color", length = 100, columnDefinition = "varchar(100) default 'neutral'")
    private String color;

    @Column(name = "gender", length = 100, columnDefinition = "varchar(100) default 'neutral'")
    private String gender;

    @Column(name = "image_url", length = 100)
    private String imageUrl;

    @Column(name = "price", columnDefinition = "int default 100")
    private int price;

    @Column(name = "rating", columnDefinition = "int default 0")
    private int rating;

    @Column(name = "variant_options", columnDefinition = "json")
    private String variantOptions;
}
