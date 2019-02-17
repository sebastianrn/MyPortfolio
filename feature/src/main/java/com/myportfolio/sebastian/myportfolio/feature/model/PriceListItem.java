package com.myportfolio.sebastian.myportfolio.feature.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;

import java.math.BigDecimal;

@Data
public class PriceListItem {
    private Integer articleNumber;
    private String articleName;
    private String weight;
    private Price price;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Price {
        private Pair<Currency, BigDecimal> buyPrice;
        private Pair<Currency, BigDecimal> sellPrice;
    }
}
