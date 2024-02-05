package service;

import controller.BankController;
import entity.BankStaff;
import entity.Customer;
import entity.Loan;

public class CustomerService {

    private BankController bankController;

    public CustomerService(BankController bankController) {
        this.bankController = bankController;
    }

    public void deposit(Customer customer, double amount) {
        bankController.deposit(customer, amount);
    }

    public void withdraw(Customer customer, double amount) {
        bankController.withdraw(customer, amount);
    }

    public void transfer(Customer fromCustomer, Customer toCustomer, double amount) {
        bankController.transfer(fromCustomer, amount, toCustomer);
    }

    public void applyLoan(Customer customer, double amount, double rate, int days) {
        bankController.applyLoan(customer, amount, rate, days);
    }

    public void openAccount(Customer customer) {
        bankController.openAccount(customer);
    }

    public void closeAccount(Customer customer) {
        bankController.closeAccount(customer);
    }

    public Loan checkLoan(Customer customer) {
        return bankController.checkLoan(customer);
    }

    public double checkBalance(Customer customer) {
        return bankController.checkBalance(customer);
    }
}