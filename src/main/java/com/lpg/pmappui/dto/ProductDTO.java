package com.lpg.pmappui.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {
    private Long productId;
    private String productName;
    private String description;
    private Long categoryId;
    private String lastPurchasedDateStr;
}
