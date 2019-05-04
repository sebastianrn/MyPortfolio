package com.myportfolio.sebastian.myportfolio.feature.repository;

import android.app.Application;
import android.os.AsyncTask;
import com.myportfolio.sebastian.myportfolio.feature.PortfolioDatabase;
import com.myportfolio.sebastian.myportfolio.feature.dao.PortfolioDao;
import com.myportfolio.sebastian.myportfolio.feature.databaseEntities.Portfolio;

import java.util.List;

public class PortfolioRepository {
    private PortfolioDao portfolioDao;
    private List<Portfolio> portfolios;

    public PortfolioRepository(Application application) {
        PortfolioDatabase portfolioDatabase = PortfolioDatabase.getDatabase(application);
        portfolioDao = portfolioDatabase.portfolioDao();
        portfolios = portfolioDao.getAllPortfolios();
    }

    public List<Portfolio> getAllPortfolios() {
        return portfolios;
    }

    public void insertPortfolio(Portfolio portfolio) {
        new insertAsyncTask(portfolioDao).execute(portfolio);
    }

    private static class insertAsyncTask extends AsyncTask<Portfolio, Void, Void> {
        private PortfolioDao asyncDao;

        insertAsyncTask(PortfolioDao dao) {
            asyncDao = dao;
        }

        @Override
        protected Void doInBackground(Portfolio... portfolios) {
            asyncDao.insertPortfolio(portfolios[0]);
            return null;
        }
    }

}
