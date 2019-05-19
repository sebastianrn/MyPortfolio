package com.myportfolio.sebastian.myportfolio.feature.dao;

import android.content.Context;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.runner.AndroidJUnit4;
import com.myportfolio.sebastian.myportfolio.feature.PortfolioDatabase;
import com.myportfolio.sebastian.myportfolio.feature.databaseEntities.DailyRate;
import com.myportfolio.sebastian.myportfolio.feature.databaseEntities.Portfolio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.Instant;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class DailyRateDaoTest {
    private PortfolioDatabase portfolioDatabase;
    private PortfolioDao portfolioDao;
    private DailyRateDao dailyRateDao;
    private final Integer PORTFOLIO_ID = 1;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        portfolioDatabase = Room.inMemoryDatabaseBuilder(context, PortfolioDatabase.class).build();
        portfolioDao = portfolioDatabase.portfolioDao();
        dailyRateDao = portfolioDatabase.dailyRateDao();
    }

    @After
    public void closeDb() {
        portfolioDatabase.close();
    }

    @Test
    public void test_insertDailyRateForPortfolio() {
        DailyRate dailyRate = createDailyRate(12, Instant.now(), 123, "article1", "1 Unze", 222L, 200L);

        portfolioDao.insertPortfolio(getPortfolio());
        dailyRateDao.insertDailyRateForPortfolio(dailyRate);
        assertEquals(1, dailyRateDao.getAllDailyRatesForPortfolio(PORTFOLIO_ID).size());
    }

    private Portfolio getPortfolio() {
        return Portfolio.builder()
                .id(PORTFOLIO_ID)
                .portfolioName("Dummy Portfolio")
                .build();
    }

    private DailyRate createDailyRate(Integer id,
                                      Instant created,
                                      Integer articleNumber,
                                      String articleName,
                                      String weight,
                                      Long buyPrice,
                                      Long sellPrice) {
        return DailyRate.builder()
                .id(id)
                .created(created)
                .portfolioId(PORTFOLIO_ID)
                .articleNumber(articleNumber)
                .articleName(articleName)
                .weight(weight)
                .buyPrice(buyPrice)
                .sellPrice(sellPrice)
                .build();
    }

}