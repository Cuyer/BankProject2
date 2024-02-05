package entity;

public class Customer extends Person {

    private String accountNumber;
    private double balance;
    private Loan loan;

    public Customer(String name, String address, String accountNumber) {
        super(name, address);
        this.accountNumber = accountNumber;
        this.balance = 0;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }
}
