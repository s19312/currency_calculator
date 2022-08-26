package task.fedorchenko.currency_calculator;

import java.io.Serializable;

public class EURCurrencyCalculator {
    private double eurValue;
    private String targetCurrency;
    private double rate;
    private CurrencyXMLParser parser;

    public EURCurrencyCalculator(double eurValue, String targetCurrency){
        this.parser = new CurrencyXMLParser();
        setEurValue(eurValue);
        newTargetCurrency(targetCurrency);
    }

    public void changeEURvalue(double newValue){
        setEurValue(newValue);
    }

    public void newTargetCurrency(String newTarget){
        setTargetCurrency(newTarget);
        setRate();
    }
    public double exchange(){
        return this.eurValue * getRate();
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public double getRate(){
        return this.rate;
    }

    public double getEurValue() {
        return eurValue;
    }

    private void setRate(){
        this.rate = parser.parseCurrency(getTargetCurrency());
    }

    private void setEurValue(double eurValue) {
        this.eurValue = eurValue;
    }

    private void setTargetCurrency(String targetCurrency) {
        if(targetCurrency == null || targetCurrency.trim().equals("")){
            throw new RuntimeException("Target currency Null or Empty!");
        }
        this.targetCurrency = targetCurrency;
    }
}

