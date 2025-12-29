import java.io.*;
import java.util.Scanner;

// ---------------- ABSTRACT CLASS ----------------
abstract class Account implements Serializable {

    private int accNo;
    private String name;
    protected double balance;

    // constructor
    public Account(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    // encapsulation using getters
    public int getAccNo() {
        return accNo;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    // abstract methods
    abstract void deposit(double amt);
    abstract void withdraw(double amt);

    // normal method
    public void showDetails() {
        System.out.println("Account No : " + accNo);
        System.out.println("Name       : " + name);
        System.out.println("Balance    : " + balance);
    }
}

// ---------------- SAVINGS ACCOUNT ----------------
class Savings extends Account {

    public Savings(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    // method overriding
    public void deposit(double amt) {
        balance = balance + amt;
        System.out.println("Money deposited in Savings Account");
    }

    public void withdraw(double amt) {
        if (balance >= amt) {
            balance = balance - amt;
            System.out.println("Money withdrawn from Savings Account");
        } else {
            System.out.println("Not enough balance");
        }
    }
}

// ---------------- CURRENT ACCOUNT ----------------
class Current extends Account {

    public Current(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    // method overriding
    public void deposit(double amt) {
        balance = balance + amt;
        System.out.println("Money deposited in Current Account");
    }

    public void withdraw(double amt) {
        if (balance >= amt) {
            balance = balance - amt;
            System.out.println("Money withdrawn from Current Account");
        } else {
            System.out.println("Not enough balance");
        }
    }
}

// ---------------- MAIN CLASS ----------------
public class BankManagement {

    static Scanner sc = new Scanner(System.in);
    static String fileName = "bank.txt";

    public static void main(String[] args) {

        Account acc = readFromFile();
        int ch;

        do {
            System.out.println("\n---- BANK MENU ----");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Enquiry");
            System.out.println("5. Show Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {

                case 1:
                    acc = createAccount();
                    saveToFile(acc);
                    break;

                case 2:
                    if (acc != null) {
                        System.out.print("Enter amount: ");
                        acc.deposit(sc.nextDouble()); // runtime polymorphism
                        saveToFile(acc);
                    }
                    break;

                case 3:
                    if (acc != null) {
                        System.out.print("Enter amount: ");
                        acc.withdraw(sc.nextDouble()); // runtime polymorphism
                        saveToFile(acc);
                    }
                    break;

                case 4:
                    if (acc != null)
                        System.out.println("Balance: " + acc.getBalance());
                    break;

                case 5:
                    if (acc != null)
                        acc.showDetails();
                    break;

                case 6:
                    System.out.println("Thank You");
                    break;

                default:
                    System.out.println("Wrong choice");
            }

        } while (ch != 6);
    }

    // -------- create account ----------
    static Account createAccount() {

        System.out.print("Enter Account Number: ");
        int no = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Balance: ");
        double bal = sc.nextDouble();

        System.out.print("1. Savings  2. Current : ");
        int type = sc.nextInt();

        if (type == 1)
            return new Savings(no, name, bal);
        else
            return new Current(no, name, bal);
    }

    // -------- file write ----------
    static void saveToFile(Account acc) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(acc);
            out.close();
        } catch (Exception e) {
            System.out.println("File error");
        }
    }

    // -------- file read ----------
    static Account readFromFile() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            Account acc = (Account) in.readObject();
            in.close();
            return acc;
        } catch (Exception e) {
            return null;
        }
    }
}

