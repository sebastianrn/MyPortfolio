package com.myportfolio.sebastian.myportfolio.feature.databaseEntities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import com.myportfolio.sebastian.myportfolio.feature.scrapingEntities.Currency;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@Entity(tableName = "daily_rates",
        foreignKeys = @ForeignKey(
                entity = Portfolio.class,
                parentColumns = "id",
                childColumns = "portfolioId"))
public class DailyRate {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "portfolio_id")
    private int portfolioId;
    private Instant created;
    @ColumnInfo(name = "article_number")
    private Integer articleNumber;
    @ColumnInfo(name = "article_name")
    private String articleName;
    private String weight;
    private Pair<Currency, BigDecimal> buyPrice;
    private Pair<Currency, BigDecimal> sellPrice;
}
