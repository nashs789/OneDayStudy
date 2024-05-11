package org.example.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
    private String href;
    private String itemNo;
    private String itemName;
    private String price;
    private String imgUrl;
}
