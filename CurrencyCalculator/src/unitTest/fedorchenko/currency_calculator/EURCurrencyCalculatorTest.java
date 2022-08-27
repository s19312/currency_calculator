package unitTest.fedorchenko.currency_calculator;

import main.fedorchenko.currency_calculator.EURCurrencyCalculator;
import main.fedorchenko.currency_calculator.TargetCurrency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EURCurrencyCalculatorTest {
    private EURCurrencyCalculator calculator;

    /**
     * Set up
     * @result Create calculator with initial data
     */
    @BeforeEach
    void setUp() {
        calculator = new EURCurrencyCalculator(100, TargetCurrency.USD);
    }

    /**
     * Get rate
     * @result Rate of target currency will be taken from data file without any errors
     */
    @Test
    void getRate() {
        assertEquals(0.9970, calculator.getRate());
    }

    /**
     * Change EUR value
     * Provided new EUR value to calculate
     * @result Value will be persisted without any errors,
     *              and EURValue will no longer be a previous value
     */
    @Test
    void changeEURvalue() {
        calculator.changeEURvalue(50);
        assertEquals(50,calculator.getEurAmount());
    }


    /**
     * New target currency
     * Create and assign new target currency to calculator
     * @result new target currency will be assigned without any errors
     */
    @Test
    void newTargetCurrency() {
        TargetCurrency newTarget = TargetCurrency.BGN;
        calculator.newTargetCurrency(newTarget);
        assertEquals(newTarget, calculator.getTargetCurrency());
    }

    /**
     * Calculate
     * Add a valid EUR value and assign target currency
     * @result calculator will return correct value of target currency
     */
    @Test
    void calculate() {
        calculator.changeEURvalue(150);
        calculator.newTargetCurrency(TargetCurrency.PLN);
        assertEquals(713.67,calculator.calculate());
    }

}