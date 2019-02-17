package com.myportfolio.sebastian.myportfolio.feature.scraping;

import com.myportfolio.sebastian.myportfolio.feature.model.PriceListItem;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ScrapingServiceTest {

    @Test
    public void initializeWebsite() {
        ScrapingService scrapingService = new ScrapingService();
        List<PriceListItem> priceListFromWebsite = scrapingService.getPriceListFromWebsite();

        assertFalse(priceListFromWebsite.isEmpty());
    }
}