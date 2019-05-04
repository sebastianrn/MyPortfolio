package com.myportfolio.sebastian.myportfolio.feature;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.myportfolio.sebastian.myportfolio.feature.dao.DailyRateDao;
import com.myportfolio.sebastian.myportfolio.feature.dao.PortfolioDao;
import com.myportfolio.sebastian.myportfolio.feature.databaseEntities.DailyRate;
import com.myportfolio.sebastian.myportfolio.feature.databaseEntities.Portfolio;
import com.myportfolio.sebastian.myportfolio.feature.utils.PortfolioTypeConverter;

@Database(entities = {Portfolio.class, DailyRate.class}, version = 1)
@TypeConverters(PortfolioTypeConverter.class)
public abstract class PortfolioDatabase extends RoomDatabase {
    public abstract PortfolioDao portfolioDao();

    public abstract DailyRateDao dailyRateDao();

    private static volatile PortfolioDatabase INSTANCE;

    public static PortfolioDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PortfolioDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PortfolioDatabase.class, "portfolio_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
