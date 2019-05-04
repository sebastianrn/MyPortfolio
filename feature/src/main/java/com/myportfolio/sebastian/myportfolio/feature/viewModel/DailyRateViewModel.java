package com.myportfolio.sebastian.myportfolio.feature.viewModel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.myportfolio.sebastian.myportfolio.feature.dao.AsyncDailyRate;
import com.myportfolio.sebastian.myportfolio.feature.databaseEntities.DailyRate;
import com.myportfolio.sebastian.myportfolio.feature.repository.DailyRateRepository;

import java.util.List;

public class DailyRateViewModel extends AndroidViewModel {
    private DailyRateRepository dailyRateRepository;

    private List<DailyRate> dailyRatesForPortfolio;

    public DailyRateViewModel(Application application) {
        super(application);
        dailyRateRepository = new DailyRateRepository(application);
        dailyRatesForPortfolio = dailyRateRepository.getDailyRatesForPortfolio();
    }

    List<DailyRate> getDailyRatesForPortfolio() {
        return dailyRatesForPortfolio;
    }

    public void insertDailyRateForPorfolio(AsyncDailyRate asyncDailyRate) {
        dailyRateRepository.insertDailyRate(asyncDailyRate);
    }
}
