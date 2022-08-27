package main.fedorchenko.currency_calculator;

public enum TargetCurrency {
    USD("USD"),
    JPY("JPY"),
    BGN("BGN"),
    CZK("CZK"),
    DKK("DKK"),
    GBP("GBP"),
    HUF("HUF"),
    PLN("PLN"),
    RON("RON"),
    SEK("SEK"),
    CHF("CHF"),
    ISK("ISK"),
    NOK("NOK"),
    HRK("HRK"),
    TRY("TRY"),
    AUD("AUD"),
    BRL("BRL"),
    CAD("CAD"),
    CNY("CNY"),
    NKD("NKD"),
    IDR("IDR"),
    ILS("ILS"),
    INR("INR"),
    RKW("RKW"),
    MXN("MXN"),
    MYR("MYR"),
    NZD("NZD"),
    PHP("PHP"),
    SGD("SGD"),
    THB("THB"),
    ZAR("ZAR");

    private String value;

    TargetCurrency(String value) {
        this.value = value;
    }
}
