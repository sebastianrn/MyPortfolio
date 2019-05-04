package com.myportfolio.sebastian.myportfolio.feature.utils;

import androidx.room.TypeConverter;

import java.time.Instant;

public class PortfolioTypeConverter {

    @TypeConverter
    public static Instant toDate(Long value) {
        return value == null ? null : Instant.ofEpochSecond(value);
    }

    @TypeConverter
    public static Long toLong(Instant value) {
        return value == null ? null : value.getEpochSecond();
    }
}
