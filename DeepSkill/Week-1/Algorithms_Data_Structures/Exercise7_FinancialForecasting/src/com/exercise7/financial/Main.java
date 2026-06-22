package com.exercise7.financial;

public class Main {
    public static void main(String[] args) {
        double presentValue = 1000.0;
        double growthRate = 0.05;
        int years = 10;

        // Recursive
        double futureValue = FinancialForecast.calculateFutureValue(presentValue, growthRate, years);
        System.out.println("--- Recursive ---");
        System.out.printf("Future Value after %d years: %.2f%n", years, futureValue);

        // Memoized
        double[] memo = new double[years + 1];
        double futureValueMemo = FinancialForecast.calculateFutureValueMemo(presentValue, growthRate, years, memo);
        System.out.println("--- Memoized ---");
        System.out.printf("Future Value after %d years: %.2f%n", years, futureValueMemo);
    }
}