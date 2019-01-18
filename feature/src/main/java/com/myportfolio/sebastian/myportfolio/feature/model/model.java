package com.myportfolio.sebastian.myportfolio.feature.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class model {
    private String articleNumber;
    private String articleName;
    private BigDecimal weight;
    private BigDecimal buyPrice;
    private BigDecimal sellPrice;
}
