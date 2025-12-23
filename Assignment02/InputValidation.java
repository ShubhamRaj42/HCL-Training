import java.util.*;
import java.util.regex.Pattern;

public class InputValidation {

    public static boolean validate(String input, String regex) {
        return Pattern.matches(regex, input);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        try {
            while (true) {

                System.out.println("1. Validate Mobile Number");
                System.out.println("2. Validate Email ID");
                System.out.println("3. Validate Username");
                System.out.println("4. Validate Password");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();
                sc.nextLine(); // clear buffer

                switch (choice) {

                    case 1:
                        System.out.print("Enter Mobile Number: ");
                        String mobile = sc.nextLine();

                        String mobileRegex = "[6-9][0-9]{9}";

                        if (validate(mobile, mobileRegex)) {
                            System.out.println("Welcome! Mobile number is valid.");
                        } else {
                            System.out.println("Invalid Mobile Number!");
                        }
                        break;

                    case 2:
                        System.out.print("Enter Email ID: ");
                        String email = sc.nextLine();

                        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

                        if (validate(email, emailRegex)) {
                            System.out.println("Welcome! Email ID is valid.");
                        } else {
                            System.out.println("Invalid Email ID!");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Username: ");
                        String username = sc.nextLine();

                        String userRegex = "[A-Za-z0-9]{4,15}";

                        if (validate(username, userRegex)) {
                            System.out.println("Welcome! Username is valid.");
                        } else {
                            System.out.println("Invalid Username!");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Password: ");
                        String password = sc.nextLine();

                        String passRegex = "(?=.*[A-Za-z])(?=.*[0-9]).{6,}";

                        if (validate(password, passRegex)) {
                            System.out.println("Welcome! Password is valid.");
                        } else {
                            System.out.println("Invalid Password!");
                        }
                        break;

                    case 5:
                        System.out.println("Thank you! Program exited.");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: Invalid input!");
        }
    }
}
