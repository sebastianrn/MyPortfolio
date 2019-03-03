package com.myportfolio.sebastian.myportfolio.feature.scrapingEntities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    private Pair<Currency, BigDecimal> buyPrice;
    private Pair<Currency, BigDecimal> sellPrice;
}
