package  com.MortgageAnalyzer;

public interface MortgageAnalyzerInterface {
    void enterLoanAmount(double principal);
    void annualRateOfInterest(double interestRate);
    void durationOfTheLoan(float loanDurationInMonth);
    Boolean verify();
    String correctInput();
}
