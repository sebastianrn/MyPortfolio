package com.myportfolio.sebastian.myportfolio.feature.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.myportfolio.sebastian.myportfolio.feature.dao.AsyncDailyRate;
import com.myportfolio.sebastian.myportfolio.feature.databaseEntities.DailyRate;
import com.myportfolio.sebastian.myportfolio.feature.repository.DailyRateRepository;

import java.util.List;

public class DailyRateViewModel extends AndroidViewModel {
    private DailyRateRepository dailyRateRepository;

    private LiveData<List<DailyRate>> dailyRatesForPortfolio;

    public DailyRateViewModel(Application application) {
        super(application);
        dailyRateRepository = new DailyRateRepository(application);
        dailyRatesForPortfolio = dailyRateRepository.getDailyRatesForPortfolio();
    }

    LiveData<List<DailyRate>> getDailyRatesForPortfolio() {
        return dailyRatesForPortfolio;
    }

    public void insertDailyRateForPorfolio(AsyncDailyRate asyncDailyRate) {
        dailyRateRepository.insertDailyRate(asyncDailyRate);
    }
}
