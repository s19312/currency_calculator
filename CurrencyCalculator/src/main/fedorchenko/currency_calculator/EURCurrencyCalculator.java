package main.fedorchenko.currency_calculator;

public class EURCurrencyCalculator {
    private double eurValue;
    private double rate;
    private TargetCurrency targetCurrency;
    private CurrencyXMLParser parser;

    public EURCurrencyCalculator(double eurValue, TargetCurrency targetCurrency){
        this.parser = new CurrencyXMLParser();
        setEurValue(eurValue);
        newTargetCurrency(targetCurrency);
    }

    public void changeEURvalue(double newValue){
        setEurValue(newValue);
    }

    public void newTargetCurrency(TargetCurrency newTarget){
        setTargetCurrency(newTarget);
        setRate();
    }
    public double calculate(){
        return this.eurValue * getRate();
    }

    public TargetCurrency getTargetCurrency() {
        return targetCurrency;
    }

    public double getRate(){
        return this.rate;
    }

    public double getEurValue() {
        return eurValue;
    }

    private void setRate(){
        this.rate = parser.parseCurrency(this.targetCurrency);
    }

    private void setEurValue(double eurValue) {
        this.eurValue = eurValue;
    }

    private void setTargetCurrency(TargetCurrency targetCurrency) {
        this.targetCurrency = targetCurrency;
    }
}

