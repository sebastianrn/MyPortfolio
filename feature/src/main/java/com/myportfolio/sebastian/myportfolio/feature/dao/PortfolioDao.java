package com.myportfolio.sebastian.myportfolio.feature.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.myportfolio.sebastian.myportfolio.feature.databaseEntities.Portfolio;

import java.util.List;

@Dao
public interface PortfolioDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPortfolio(Portfolio portfolio);

    @Query("SELECT * from portfolios")
    List<Portfolio> getAllPortfolios();
}
