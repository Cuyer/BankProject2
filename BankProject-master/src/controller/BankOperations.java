package controller;

import entity.Loan;
import exceptions.CustomerNotFoundException;
import entity.Customer;

import java.util.List;

public interface BankOperations {
    void addCustomer(Customer customer);
    void removeCustomer(Customer customer);
    List<Customer> getAccounts();
    void deposit(String accountNumber, double amount);
    void withdraw(String accountNumber, double amount);
    void transfer(String sourceAccountNumber, String destinationAccountNumber, double amount);
    double checkBalance(String accountNumber) throws CustomerNotFoundException;
    void applyLoan(String accountNumber, double amount, double rate, int days);
    Loan checkLoan(String accountNumber);
}
