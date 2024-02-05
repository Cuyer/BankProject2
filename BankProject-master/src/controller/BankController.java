package controller;

import entity.Customer;
import entity.Loan;
import exceptions.CustomerNotFoundException;

import java.util.List;

public class BankController {
    private BankOperations bankOperations;

    public BankController(BankOperations bankOperations) {
        this.bankOperations = bankOperations;
    }

    public void openAccount(Customer customer) {
        bankOperations.addCustomer(customer);
    }

    public void deposit(Customer customer, double amount) {
        bankOperations.deposit(customer.getAccountNumber(), amount);
    }


    public void withdraw(Customer customer, double amount) {
        bankOperations.withdraw(customer.getAccountNumber(), amount);
    }


    public void transfer(Customer customer, double amount, Customer destination) {
        bankOperations.transfer(customer.getAccountNumber(), destination.getAccountNumber(), amount);
    }


    public double checkBalance(Customer customer) {
        try {
            return bankOperations.checkBalance(customer.getAccountNumber());
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
            return 0.0;
        }
    }

    public Loan checkLoan(Customer customer) {
        return bankOperations.checkLoan(customer.getAccountNumber());
    }


    public void applyLoan(Customer customer, double amount, double rate, int days) {
        bankOperations.applyLoan(customer.getAccountNumber(), amount, rate, days);
    }


    public void closeAccount(Customer customer) {
        bankOperations.removeCustomer(customer);
    }

    public List<Customer> getAccounts() {
        return bankOperations.getAccounts();
    }
}
