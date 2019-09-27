package com.myportfolio.sebastian.myportfolio.feature;

import org.junit.Test;

public class PortfolioUpdaterTest {

    @Test
    public void updateDailyRates() {
        PortfolioUpdater portfolioUpdater = new PortfolioUpdater();

        portfolioUpdater.updateDailyRates();
    }
}