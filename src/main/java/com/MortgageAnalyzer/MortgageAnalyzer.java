package  com.MortgageAnalyzer;

public class MortgageAnalyzer implements MortgageAnalyzerInterface {
    private double principal;
    private double interestRate;
    private float loanDurationInMonth;

    public void enterLoanAmount(double principal) {
        this.principal = principal;
    }

    public void annualRateOfInterest(double interestRate) {
        this.interestRate = interestRate;
    }

    public void durationOfTheLoan(float loanDurationInMonth) {
        this.loanDurationInMonth = loanDurationInMonth;
    }

    public Boolean verify() {
        if (interestRate < 0 || interestRate > 1) {
            return false;
        }
        if (principal < 0) {
            return false;
        }
        if (loanDurationInMonth < 0) {
            return false;
        }
        return true;
    }


    public String correctInput() {
        if (interestRate < 0 || interestRate > 1) {
            return "Interest Rate must be between 0 and 1 . Found " + interestRate;
        }

        if (principal < 0) {
            return "Principal must be greater than 0 . Found " + principal;
        }

        if (loanDurationInMonth < 0) {
            return "Loan duration in month must be greater than 0. Found " + loanDurationInMonth ;
        }
        return "";
    }

}
