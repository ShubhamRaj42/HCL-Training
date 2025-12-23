import java.util.*;

/* Creating Interface for banking operations */
interface BankOperations {
    void deposit(int amount);

    void withdraw(int amount) throws Exception;

    void checkBalance();
}

/* Creating Interface for customer related operations */
interface CustomerOperations {
    void CustomerDetails();
}

class BankAccount implements BankOperations, CustomerOperations {

    private String customerName;
    private int accountNumber;
    private double balance;

    // Constructor
    BankAccount(String name, int accNo, int initialBalance) {
        customerName = name;
        accountNumber = accNo;
        balance = initialBalance;
    }

    // Deposit method
    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount!");
            return;
        }
        balance += amount;
        System.out.println("Amount deposited successfully.");
    }

    // Withdraw method with exception handling
    public void withdraw(int amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Invalid withdrawal amount!");
        }
        if (amount > balance) {
            throw new Exception("Insufficient balance!");
        }
        balance -= amount;
        System.out.println("Amount withdrawn successfully.");
    }

    // Check balance
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    // Display customer details
    public void CustomerDetails() {
        System.out.println("\nCustomer Name: " + customerName);
        System.out.println("Account Number: " + accountNumber);
    }
}

public class BankApplication {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount account = new BankAccount("Shubham", 10101, 5000);

        try {
            account.CustomerDetails();
            account.checkBalance();

            System.out.print("\nEnter deposit amount: ");
            int dep = sc.nextInt();
            account.deposit(dep);
            account.checkBalance();

            System.out.print("\nEnter withdrawal amount: ");
            int with = sc.nextInt();
            account.withdraw(with);
            account.checkBalance();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
