package main.fedorchenko.currency_calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TargetCurrency targetCurrency;
        EURCurrencyCalculator calculator;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert amount of EUR: ");
        double eurAmount = Double.parseDouble(scanner.nextLine());

        System.out.println("Provide target currency(e.g USD): ");
        try {
            targetCurrency = TargetCurrency.valueOf(scanner.nextLine());
            calculator = new EURCurrencyCalculator(eurAmount, targetCurrency);
            System.out.println(calculator.getEurAmount() + "EUR -> " + targetCurrency + " = " + calculator.calculate());
        } catch (IllegalArgumentException ex) {
            System.out.println("Such target currency does not exists!");
        }
    }
}
