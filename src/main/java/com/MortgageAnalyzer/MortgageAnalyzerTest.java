package com.MortgageAnalyzer;

public class MortgageAnalyzerTest {

    public static void testCase1() {
        CalculateMortgageDetails calculateMortgageDetails = new CalculateMortgageDetails();
        double principal = 140000;
        double interestRate = 0.08;
        float loanDurationInMonth = 360;
        String output  = calculateMortgageDetails.calculate(principal, interestRate, loanDurationInMonth);
        System.out.println(output);
    }


     public static void testCase2() {
        CalculateMortgageDetails calculateMortgageDetails = new CalculateMortgageDetails();
        double principal = 140000;
        double interestRate = 62;
        float loanDurationInMonth = 360;
        String output  = calculateMortgageDetails.calculate(principal, interestRate, loanDurationInMonth);
        System.out.println(output);
    }


    public static void testCase3() {
        CalculateMortgageDetails calculateMortgageDetails = new CalculateMortgageDetails();
        double principal = -2;
        double interestRate = 0.08;
        float loanDurationInMonth = 360;
        String output  = calculateMortgageDetails.calculate(principal, interestRate, loanDurationInMonth);
        System.out.println(output);
    }

    public static void testCase4() {
        CalculateMortgageDetails calculateMortgageDetails = new CalculateMortgageDetails();
        double principal = 140000;
        double interestRate = 0.08;
        float loanDurationInMonth = -1;
        String output  = calculateMortgageDetails.calculate(principal, interestRate, loanDurationInMonth);
        System.out.println(output);
    }


    public static void main(String[] args) {
        System.out.println("Test Case 1");
        testCase1();

        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println("Test Case 2");
        testCase2();

        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println("Test Case 3");
        testCase3();

        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println("Test Case 4");
        testCase4();
    }
}
