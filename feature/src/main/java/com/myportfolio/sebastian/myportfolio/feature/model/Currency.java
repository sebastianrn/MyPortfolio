package com.myportfolio.sebastian.myportfolio.feature.model;

public enum Currency {
    CHF("CHF");

    private final String currencyValue;

    Currency(String currencyValue) {
        this.currencyValue = currencyValue;
    }

    public String getCurrencyValue() {
        return currencyValue;
    }
}
