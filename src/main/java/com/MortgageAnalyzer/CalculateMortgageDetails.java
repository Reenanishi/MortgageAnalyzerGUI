package com.MortgageAnalyzer;

public class CalculateMortgageDetails {
    MortgageAnalyzer mortgageAnalyzer;

    public CalculateMortgageDetails() {
        mortgageAnalyzer  = new MortgageAnalyzer();
    }

    public String calculate(double principal, double interestRate, float loanDurationInMonth) {
        mortgageAnalyzer.enterLoanAmount(principal);
        mortgageAnalyzer.annualRateOfInterest(interestRate);
        mortgageAnalyzer.durationOfTheLoan(loanDurationInMonth);
        double monthlyInterestRate = interestRate/12;


        if (mortgageAnalyzer.verify()) {
            String result = "\n";
            result += "Amount of Loan              - $" + principal + "\n";
            result += "Annual Interest Rate        - " + interestRate * 100 + "%\n";
            result += "Duration of loan in months  - " + loanDurationInMonth + "\n";
            result += "Monthly payment             - $" + getMonthlyPayment(principal, monthlyInterestRate, loanDurationInMonth) + "\n";
            result += "Total interest paid         - $" + getTotalInterest(principal, monthlyInterestRate, loanDurationInMonth) + "\n";
            return result;
        } else {
            return "Error: " + mortgageAnalyzer.correctInput() + ". Please correct your details";
        }

    }

    public double getMonthlyPayment(double principal, double monthlyInterestRate, float loanDurationInMonth) {
        double ratePow = Math.pow(1 + monthlyInterestRate, loanDurationInMonth);
        return  (principal * monthlyInterestRate * ratePow) / (ratePow - 1);
    }

    public double getTotalInterest(double principal, double monthlyInterestRate, float loanDurationInMonth) {
        return  loanDurationInMonth * getMonthlyPayment(principal, monthlyInterestRate, loanDurationInMonth) - principal;
    }
}
