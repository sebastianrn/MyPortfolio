package com.myportfolio.sebastian.myportfolio.feature.dao;

import com.myportfolio.sebastian.myportfolio.feature.databaseEntities.DailyRate;
import lombok.Data;

@Data
public class AsyncDailyRate {
    int portfolioId;
    DailyRate dailyRate;
}
