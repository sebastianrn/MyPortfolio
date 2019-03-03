package com.myportfolio.sebastian.myportfolio.feature.dao;

import android.arch.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.myportfolio.sebastian.myportfolio.feature.databaseEntities.DailyRate;

import java.util.List;

@Dao
public interface DailyRateDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDailyRateForPortfolio(Integer portfolioId, DailyRate dailyRate);

    @Query("SELECT * FROM daily_rates WHERE  portfolio_id= :portfolioId")
    LiveData<List<DailyRate>> getAllDailyRatesForPortfolio(Integer portfolioId);
}
