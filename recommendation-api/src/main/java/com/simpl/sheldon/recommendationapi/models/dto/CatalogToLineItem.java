package com.simpl.sheldon.recommendationapi.models.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simpl.sheldon.recommendationapi.models.commons.LineItem;
import com.simpl.sheldon.recommendationapi.models.commons.LineItemMetadata;
import com.simpl.sheldon.recommendationapi.models.commons.VariantOption;
import com.simpl.sheldon.recommendationapi.models.dao.CatalogItem;

import java.util.Arrays;
import java.util.List;

public class CatalogToLineItem {

    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    }

    public static LineItem mapCatalogToLineItem(CatalogItem catalogItem) {
        LineItem lineItem = new LineItem();
        LineItemMetadata metadata = new LineItemMetadata();
        lineItem.setMetadata(metadata);

        lineItem.setTitle(catalogItem.getTitle());
        lineItem.setDescription(catalogItem.getDescription());
        lineItem.setPrice(catalogItem.getPrice());
        lineItem.setUnitPrice((long) (Math.min(catalogItem.getPrice(), 3000) * Math.random()));

        metadata.setCategory(catalogItem.getCategory());
        metadata.setVariant_Id(catalogItem.getVariantId());
        metadata.setCategory(catalogItem.getCategory());
        metadata.setImageUrl(catalogItem.getImageUrl());
        metadata.setProductUrl(catalogItem.getProductUrl());
        metadata.setSku(catalogItem.getSkuId());
        metadata.setVariant_Id(catalogItem.getVariantId());
        metadata.setGender(catalogItem.getGender());
        try {
            List<VariantOption> options = Arrays.asList(mapper.readValue(catalogItem.getVariantOptions(), VariantOption[].class));
            metadata.setVariantOptions(options);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        lineItem.setPrice(catalogItem.getPrice());
        return lineItem;
    }
}
