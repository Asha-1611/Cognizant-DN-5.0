package com.exercise7.financial;

public class FinancialForecast {

    // Recursive method
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) return presentValue;
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    // Memoized method to optimize
    public static double calculateFutureValueMemo(double presentValue, double growthRate, int years, double[] memo) {
        if (years == 0) return presentValue;
        if (memo[years] != 0) return memo[years];
        memo[years] = calculateFutureValueMemo(presentValue * (1 + growthRate), growthRate, years - 1, memo);
        return memo[years];
    }
}