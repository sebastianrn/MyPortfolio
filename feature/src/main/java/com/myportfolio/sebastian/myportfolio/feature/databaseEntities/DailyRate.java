package com.myportfolio.sebastian.myportfolio.feature.databaseEntities;

import androidx.room.*;
import com.myportfolio.sebastian.myportfolio.feature.utils.PortfolioTypeConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@Entity(tableName = "daily_rates",
        indices = @Index(value = {"id"}, unique = true),
        foreignKeys = @ForeignKey(
                entity = Portfolio.class,
                parentColumns = "id",
                childColumns = "portfolio_id"))
public class DailyRate {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "portfolio_id")
    private int portfolioId;
    @TypeConverters(PortfolioTypeConverter.class)
    private Instant created;
    @ColumnInfo(name = "article_number")
    private Integer articleNumber;
    @ColumnInfo(name = "article_name")
    private String articleName;
    private String weight;
    //private Pair<Currency, BigDecimal> buyPrice;
    //  private Pair<Currency, BigDecimal> sellPrice;
}
