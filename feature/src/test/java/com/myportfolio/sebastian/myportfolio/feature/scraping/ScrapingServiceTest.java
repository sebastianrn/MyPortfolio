package com.myportfolio.sebastian.myportfolio.feature.scraping;

import com.myportfolio.sebastian.myportfolio.feature.scrapingEntities.PriceListItem;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;

public class ScrapingServiceTest {

    @Test
    public void initializeWebsite() {
        ScrapingService scrapingService = new ScrapingService();
        List<PriceListItem> priceListFromWebsite = scrapingService.getPriceListFromWebsite();

        assertFalse(priceListFromWebsite.isEmpty());
    }
}