package org.MIFI.model;

public record Amount(double value, Currency currency) {

    public Amount(double value) {
        this( value, Currency.RUB);
    }

    public enum Currency {
        RUB,
        USD,
        EUR
    }
}
