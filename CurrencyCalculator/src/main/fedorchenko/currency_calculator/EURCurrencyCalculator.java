package main.fedorchenko.currency_calculator;

public class EURCurrencyCalculator {
    private double eurAmount; // EUR amount to calculate
    private double rate; //rate of target currency
    private TargetCurrency targetCurrency; // naming of target currency
    private CurrencyXMLParser parser;

    /**
     * Constructor
     * @param eurAmount - the EUR amount
     * @param targetCurrency - name of target currency
     */
    public EURCurrencyCalculator(double eurAmount, TargetCurrency targetCurrency){
        this.parser = new CurrencyXMLParser();
        setEurAmount(eurAmount);
        newTargetCurrency(targetCurrency);
    }

    /**
     * @param newAmount - the new amount of EUR to calculate
     * sets newAmount instead of old amount
     */
    public void changeEURvalue(double newAmount){
        setEurAmount(newAmount);
    }

    /**
     * New target currency
     * @param newTarget - name of new target currency
     * assigning new target currency and update rates
     */
    public void newTargetCurrency(TargetCurrency newTarget){
        setTargetCurrency(newTarget);
        setRate();
    }

    /**
     * Calculate
     * @return the amount of target currency based on rate and EURValue
     */
    public double calculate(){
        return this.eurAmount * getRate();
    }

    /**
     * Get target currency
     * @return the name of targetCurrency
     */
    public TargetCurrency getTargetCurrency() {
        return this.targetCurrency;
    }

    /**
     * Get rate
     * @return the rate value assigned to targetCurrency
     */
    public double getRate(){
        return this.rate;
    }

    /**
     * Get EUR amount
     * @return the amount of EUR
     */
    public double getEurAmount() {
        return this.eurAmount;
    }

    /**
     * Set rate
     * Sets rate assigned to targetCurrency
     */
    private void setRate(){
        this.rate = parser.parseCurrency(this.targetCurrency);
    }

    /**
     * Set EUR amount
     * @param eurAmount - value for set eurAmount
     */
    private void setEurAmount(double eurAmount) {
        if(eurAmount < 0){
            throw new RuntimeException("EUR amount is negative value!");
        }
        this.eurAmount = eurAmount;
    }

    /**
     * Set target currency
     * @param targetCurrency - name of target currency
     */
    private void setTargetCurrency(TargetCurrency targetCurrency) {
        this.targetCurrency = targetCurrency;
    }
}

