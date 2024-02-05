import controller.BankController;
import entity.BankStaff;
import entity.Customer;
import repository.BankDatabase;
import service.BankStaffService;
import service.CustomerService;

public class Main {
    public static void main(String[] args) {

        BankDatabase bankDatabase = BankDatabase.getInstance();
        BankController bankController = new BankController(bankDatabase);


        CustomerService customerService = new CustomerService(bankController);
        BankStaffService bankStaffService = new BankStaffService(bankController);


        Customer alice = new Customer("Alice", "123 Wonderland Lane", "ACC123");
        Customer tom = new Customer("Tom", "233 Green Street", "ACC321");
        Customer charlie = new Customer("Charlie", "789 Paradise City", "ACC789");
        BankStaff bobStaff = new BankStaff("Bob", "456 Fantasy Road", "STAFF456");

        // Open an account for Alice
        bankStaffService.openAccount(bobStaff, alice);

        // Tom opens account by himself
        customerService.openAccount(tom);

        // Bank staff deposits money for Tom
        bankStaffService.deposit(bobStaff, tom, 1200);

        // Alice deposits money
        customerService.deposit(alice, 1000);

        // Check Alice's balance
        double aliceBalance = customerService.checkBalance(alice);
        System.out.println("Alice's balance: $" + aliceBalance);

        // Check Tom's balance
        double tomBalance = customerService.checkBalance(tom);
        System.out.println("Tom's balance: $" + tomBalance);

        // Alice applies for a loan
        customerService.applyLoan(alice, 5000, 5.0, 365);

        //Print Alice Loans
        customerService.checkLoan(alice).getLoanInfo();

        // Transfer money from Charlie to Alice
        bankStaffService.openAccount(bobStaff, charlie);
        customerService.deposit(charlie, 1000);
        customerService.transfer(alice, charlie, 200);

        // Check balances after transfer
        System.out.println("Alice's balance after transfer: $" + customerService.checkBalance(alice));
        System.out.println("Charlie's balance: $" + customerService.checkBalance(charlie));
    }
}
