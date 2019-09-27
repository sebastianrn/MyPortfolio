package com.myportfolio.sebastian.myportfolio.feature;

import com.myportfolio.sebastian.myportfolio.feature.scraping.ScrapingService;
import com.myportfolio.sebastian.myportfolio.feature.scrapingEntities.PriceListItem;

import java.util.List;

public class PortfolioUpdater {
    private
    ScrapingService scrapingService = new ScrapingService();

    void updateDailyRates() {
        List<PriceListItem> priceListFromWebsite = scrapingService.getPriceListFromWebsite();

    }
}
