package com.myportfolio.sebastian.myportfolio.feature.viewModel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.myportfolio.sebastian.myportfolio.feature.databaseEntities.Portfolio;
import com.myportfolio.sebastian.myportfolio.feature.repository.PortfolioRepository;

import java.util.List;

public class PortfolioViewModel extends AndroidViewModel {
    private PortfolioRepository portfolioRepository;

    private List<Portfolio> portfolios;

    public PortfolioViewModel(Application application) {
        super(application);
        portfolioRepository = new PortfolioRepository(application);
        portfolios = portfolioRepository.getAllPortfolios();
    }

    List<Portfolio> getPortfolios() {
        return portfolios;
    }

    public void insertPorfolio(Portfolio portfolio) {
        portfolioRepository.insertPortfolio(portfolio);
    }
}
