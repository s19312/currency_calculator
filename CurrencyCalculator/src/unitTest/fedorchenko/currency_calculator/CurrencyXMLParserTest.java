package unitTest.fedorchenko.currency_calculator;

import main.fedorchenko.currency_calculator.CurrencyXMLParser;
import main.fedorchenko.currency_calculator.TargetCurrency;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyXMLParserTest {

    /**
     * Parse currency
     * @result Parser will return correct rate related to target currency
     */
    @Test
    void parseCurrency() {
        CurrencyXMLParser parser = new CurrencyXMLParser();
        TargetCurrency targetCurrency = TargetCurrency.PLN;
        assertEquals(4.7578, parser.parseCurrency(targetCurrency));
    }
}