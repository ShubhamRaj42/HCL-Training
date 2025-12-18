import java.util.Scanner;

// Custom Exception          
class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String msg) {
        super(msg);
    }
}

class BankAccount {
    String name;
    int accNo;
    double balance;

    void createAccount(String n, int a, double b) {
        name = n;
        accNo = a;
        balance = b;
        System.out.println("Account created successfully.");
    }

    void deposit(double amt) {
        balance = balance + amt;
        System.out.println("Amount deposited.");
    }

    void withdraw(double amt) throws InsufficientBalanceException {
        if (amt > balance) {
            throw new InsufficientBalanceException("Insufficient balance.");
        }
        balance = balance - amt;
        System.out.println("Amount withdrawn.");
    }

    void showBalance() {
        System.out.println("Current Balance: " + balance);
    }

    void showDetails() {
        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + accNo);
        System.out.println("Balance: " + balance);
    }
}

public class BankManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount acc = new BankAccount();
        int choice;

        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter initial balance: ");
        double bal = sc.nextDouble();

        acc.createAccount(name, accNo, bal);

        do {
            System.out.println("\n1.Deposit  2.Withdraw  3.Balance  4.Details  5.Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter amount: ");
                        acc.deposit(sc.nextDouble());
                        break;

                    case 2:
                        System.out.print("Enter amount: ");
                        acc.withdraw(sc.nextDouble());
                        break;

                    case 3:
                        acc.showBalance();
                        break;

                    case 4:
                        acc.showDetails();
                        break;

                    case 5:
                        System.out.println("Thank you.");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            }

        } while (choice != 5);

        sc.close();
    }
}
