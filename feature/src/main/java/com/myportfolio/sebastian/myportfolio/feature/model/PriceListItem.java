package com.myportfolio.sebastian.myportfolio.feature.model;

import lombok.Data;

@Data
public class PriceListItem {
    private Integer articleNumber;
    private String articleName;
    private String weight;
    private Price price;

}
