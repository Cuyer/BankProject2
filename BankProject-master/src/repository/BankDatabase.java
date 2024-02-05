package repository;

import controller.BankOperations;
import entity.Customer;
import entity.Loan;

import java.util.ArrayList;
import java.util.List;

public class BankDatabase implements BankOperations {
    private static BankDatabase instance;
    private List<Customer> customers;

    private BankDatabase() {
        this.customers = new ArrayList<>();
    }

    public static BankDatabase getInstance() {
        if (instance == null) {
            instance = new BankDatabase();
        }
        return instance;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    @Override
    public List<Customer> getAccounts() {
        return customers;
    }

    private Customer findCustomerByAccount(String accountNumber) {
        for (Customer customer : customers) {
            if (customer.getAccountNumber().equals(accountNumber)) {
                return customer;
            }
        }
        return null;
    }

    public void deposit(String accountNumber, double amount) {
        Customer customer = findCustomerByAccount(accountNumber);
        if (customer != null) {
            double newBalance = customer.getBalance() + amount;
            customer.setBalance(newBalance);
        } else {
            System.out.println("Account not found for deposit.");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        Customer customer = findCustomerByAccount(accountNumber);
        if (customer != null) {
            if (customer.getBalance() >= amount) {
                double newBalance = customer.getBalance() - amount;
                customer.setBalance(newBalance);
            } else {
                System.out.println("Insufficient funds for withdrawal.");
            }
        } else {
            System.out.println("Account not found for withdrawal.");
        }
    }

    public void transfer(String sourceAccountNumber, String destinationAccountNumber, double amount) {
        Customer sourceCustomer = findCustomerByAccount(sourceAccountNumber);
        Customer destinationCustomer = findCustomerByAccount(destinationAccountNumber);

        if (sourceCustomer != null && destinationCustomer != null && sourceCustomer.getBalance() >= amount) {

            double newSourceBalance = sourceCustomer.getBalance() - amount;
            sourceCustomer.setBalance(newSourceBalance);


            double newDestinationBalance = destinationCustomer.getBalance() + amount;
            destinationCustomer.setBalance(newDestinationBalance);
        } else {
            System.out.println("Transfer cannot be completed. Check account numbers and balance.");
        }
    }

    public double checkBalance(String accountNumber) {
        Customer customer = findCustomerByAccount(accountNumber);
        if (customer != null) {
            return customer.getBalance();
        } else {
            System.out.println("Account not found.");
            return -1;
        }
    }

    public void applyLoan(String accountNumber, double amount, double rate, int days) {
        Customer customer = findCustomerByAccount(accountNumber);
        if (customer != null) {
            Loan loan = new Loan(amount, rate, days);
            customer.setLoan(loan);
        } else {
            System.out.println("Account not found. Cannot apply for a loan.");
        }
    }

    @Override
    public Loan checkLoan(String accountNumber) {
        Customer customer = findCustomerByAccount(accountNumber);
        if (customer != null) {
            return customer.getLoan();
        } else {
            System.out.println("Account not found.");
            return null;
        }
    }
}

