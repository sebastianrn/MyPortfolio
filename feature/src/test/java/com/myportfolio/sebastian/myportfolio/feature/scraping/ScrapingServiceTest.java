package com.myportfolio.sebastian.myportfolio.feature.scraping;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScrapingServiceTest {

    @Test
    public void initializeWebsite() {
        ScrapingService scrapingService = new ScrapingService();

        scrapingService.initializeWebsite();
    }
}