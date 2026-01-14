package Mini-Project-03;

import java.util.*;

public class MainApp {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    // ---------- LOGIN ----------
    static void login() {
        System.out.print("Enter Username: ");
        String user = sc.next();
        System.out.print("Enter Password: ");
        String pass = sc.next();

        if (!user.equals("admin") || !pass.equals("admin")) {
            System.out.println("Invalid Username or Password");
            System.exit(0);
        }
        System.out.println("Login Successful\n");
    }

    // ---------- CHECK UNIQUE ENO ----------
    static boolean isEnoExists(int eno) {
        for (Student s : students) {
            if (s.eno == eno)
                return true;
        }
        return false;
    }

    // ---------- ADD STUDENT ----------
    static void addStudent() {
        try {
            System.out.print("Enter Eno: ");
            int eno = sc.nextInt();

            if (isEnoExists(eno))
                throw new ValidationException("Eno must be unique");

            System.out.print("Enter Name: ");
            String name = sc.next();

            System.out.print("Enter Branch: ");
            String branch = sc.next();
            if (branch.isEmpty())
                throw new ValidationException("Branch cannot be empty");

            System.out.print("Enter Semester: ");
            String sem = sc.next();
            if (sem.isEmpty())
                throw new ValidationException("Semester cannot be empty");

            System.out.print("Enter Percentage: ");
            double per = sc.nextDouble();
            if (per <= 0)
                throw new ValidationException("Percentage must be positive");

            students.add(new Student(eno, name, branch, sem, per));
            System.out.println("Student Added Successfully");

        } catch (ValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ---------- DISPLAY ALL ----------
    static void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No Students Found");
            return;
        }
        for (Student s : students)
            System.out.println(s);
    }

    // ---------- SEARCH ----------
    static void searchStudent() {
        System.out.print("Enter Eno: ");
        int eno = sc.nextInt();

        for (Student s : students) {
            if (s.eno == eno) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student Not Found");
    }

    // ---------- UPDATE BRANCH ----------
    static void updateBranch() {
        System.out.print("Enter Eno: ");
        int eno = sc.nextInt();

        for (Student s : students) {
            if (s.eno == eno) {
                System.out.print("Enter New Branch: ");
                s.branch = sc.next();
                System.out.println("Branch Updated");
                return;
            }
        }
        System.out.println("Student Not Found");
    }

    // ---------- DELETE ----------
    static void deleteStudent() {
        System.out.print("Enter Eno: ");
        int eno = sc.nextInt();

        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().eno == eno) {
                it.remove();
                System.out.println("Student Deleted");
                return;
            }
        }
        System.out.println("Student Not Found");
    }

    // ---------- SORT ----------
    static void sortStudents() {
        Collections.sort(students);
        displayAll();
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {

        login();

        while (true) {
            System.out.println("\n1.Add Student");
            System.out.println("2.Display All Students");
            System.out.println("3.Search Student by Eno");
            System.out.println("4.Update Student Branch");
            System.out.println("5.Delete Student by Eno");
            System.out.println("6.Display Sorted Students");
            System.out.println("7.Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateBranch();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    sortStudents();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
