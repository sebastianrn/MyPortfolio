package com.myportfolio.sebastian.myportfolio.feature.databaseEntities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(tableName = "portfolios",
        indices = @Index(value = {"id"}, unique = true))
public class Portfolio {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "portfolio_name")
    private String portfolioName;
    //private Transaction transaction;
    //@ColumnInfo(name = "daily_rates")
    //private List<DailyRate> dailyRates;
    //private CurrentValue currentValue;


}
