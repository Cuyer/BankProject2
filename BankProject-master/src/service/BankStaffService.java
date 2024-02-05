package service;

import controller.BankController;
import entity.BankStaff;
import entity.Customer;
import entity.Loan;

public class BankStaffService {

    private BankController bankController;

    public BankStaffService(BankController bankController) {
        this.bankController = bankController;
    }

    public void openAccount(BankStaff staff, Customer customer) {
        bankController.openAccount(customer);
    }

    public void closeAccount(BankStaff staff, Customer customer) {
        bankController.closeAccount(customer);
    }

    public void deposit(BankStaff staff, Customer customer, double amount) {
        bankController.deposit(customer, amount);
    }

    public void withdraw(BankStaff staff, Customer customer, double amount) {
        bankController.withdraw(customer, amount);
    }

    public void transfer(BankStaff staff, Customer fromCustomer, Customer toCustomer, double amount) {
        bankController.transfer(fromCustomer, amount, toCustomer);
    }

    public Loan checkLoan(BankStaff staff, Customer customer) {
        return bankController.checkLoan(customer);
    }

    public double checkBalance(BankStaff staff, Customer customer) {
        return bankController.checkBalance(customer);
    }
}

