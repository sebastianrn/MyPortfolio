package com.myportfolio.sebastian.myportfolio.feature.dao;

import android.content.Context;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.runner.AndroidJUnit4;
import com.myportfolio.sebastian.myportfolio.feature.PortfolioDatabase;
import com.myportfolio.sebastian.myportfolio.feature.databaseEntities.DailyRate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static io.github.benas.randombeans.api.EnhancedRandom.random;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class DailyRateDaoTest {
    private PortfolioDatabase portfolioDatabase;
    private DailyRateDao dailyRateDao;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        portfolioDatabase = Room.inMemoryDatabaseBuilder(context, PortfolioDatabase.class).build();
        dailyRateDao = portfolioDatabase.dailyRateDao();
    }

    @After
    public void closeDb() throws IOException {
        portfolioDatabase.close();
    }

    @Test
    public void test_insertDailyRateForPortfolio() {
        DailyRate dailyRate = random(DailyRate.class);
        dailyRateDao.insertDailyRateForPortfolio(dailyRate);
        dailyRateDao.getAllDailyRatesForPortfolio(1);
        assertEquals(1, dailyRateDao.getAllDailyRatesForPortfolio(1).size());
    }

    @Test
    public void getAllDailyRatesForPortfolio() {
    }
}