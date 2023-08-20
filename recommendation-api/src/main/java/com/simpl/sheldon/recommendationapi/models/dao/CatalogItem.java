package com.simpl.sheldon.recommendationapi.models.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@ToString
@Getter @Setter
public class CatalogItem {
    public static final String tableName = "product_catalog";

    @Id
    @Column(name = "id", length = 100, nullable = false)
    private String id;

    @Column(name = "sku_id", length = 100)
    private String skuId;

    @Column(name = "merchant_id", nullable = false)
    private String merchantId;

    @Column(name = "variant_id", length = 100)
    private Long variantId;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "category", length = 100, columnDefinition = "varchar(100) default 'generic'")
    private String category;

    @Column(name = "color", length = 100, columnDefinition = "varchar(100) default 'neutral'")
    private String color;

    @Column(name = "gender", length = 100, columnDefinition = "varchar(100) default 'neutral'")
    private String gender;

    @Column(name = "image_url", length = 500)
    private String imageUrl;

    @Column(name = "product_url", length = 500)
    private String productUrl;

    @Column(name = "category_color", length = 500)
    private String categoryColor;

    @Column(name = "price", columnDefinition = "long default 100")
    private Long price;

    @Column(name = "rating", columnDefinition = "long default 0")
    private Long rating;

    @Column(name = "variant_options")
    private String variantOptions;

    @Column(name = "metadata")
    private String metadata;

    @Transient
    public int score;
}
