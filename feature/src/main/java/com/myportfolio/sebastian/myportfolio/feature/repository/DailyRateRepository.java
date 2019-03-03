package com.myportfolio.sebastian.myportfolio.feature.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import com.myportfolio.sebastian.myportfolio.feature.PortfolioDatabase;
import com.myportfolio.sebastian.myportfolio.feature.dao.AsyncDailyRate;
import com.myportfolio.sebastian.myportfolio.feature.dao.DailyRateDao;
import com.myportfolio.sebastian.myportfolio.feature.databaseEntities.DailyRate;

import java.util.List;

public class DailyRateRepository {
    private DailyRateDao dailyRateDao;
    private LiveData<List<DailyRate>> dailyRatesForPortfolio;

    public DailyRateRepository(Application application) {
        PortfolioDatabase portfolioDatabase = PortfolioDatabase.getDatabase(application);
        dailyRateDao = portfolioDatabase.dailyRateDao();
        dailyRatesForPortfolio = dailyRateDao.getAllDailyRatesForPortfolio(null);
    }

    public LiveData<List<DailyRate>> getDailyRatesForPortfolio() {
        return dailyRatesForPortfolio;
    }

    public void insertDailyRate(AsyncDailyRate asyncDailyRate) {
        new insertAsyncTask(dailyRateDao).execute(asyncDailyRate);
    }

    private static class insertAsyncTask extends AsyncTask<AsyncDailyRate, Void, Void> {
        private DailyRateDao asyncDao;

        insertAsyncTask(DailyRateDao dao) {
            asyncDao = dao;
        }

        @Override
        protected Void doInBackground(AsyncDailyRate... asyncDailyRates) {
            asyncDao.insertDailyRateForPortfolio(asyncDailyRates[0].getPortfolioId(), asyncDailyRates[0].getDailyRate());
            return null;
        }
    }

}
