import java.util.*;
import java.util.regex.Pattern;

interface StudentOperations {
    void addStudent(Student s);

    void displayStudents();

    void removeStudent(int roll);

    void searchStudent(int roll);
}

class Student {
    int rollNo;
    String name;
    int marks;

    Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }
}

/* Implementation class */
class StudentManager implements StudentOperations {

    // Using List, ArrayList and Vector
    List<Student> studentList = new ArrayList<>();
    Vector<Student> studentVector = new Vector<>();

    // Add student
    public void addStudent(Student s) {
        studentList.add(s);
        studentVector.add(s);
        System.out.println("Student added successfully.");
    }

    // Display students
    public void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\nRoll No\tName\tMarks");
        for (Student s : studentList) {
            System.out.println(s.rollNo + "\t" + s.name + "\t" + s.marks);
        }
    }

    // Remove student
    public void removeStudent(int roll) {
        Iterator<Student> it = studentList.iterator();
        boolean found = false;

        while (it.hasNext()) {
            Student s = it.next();
            if (s.rollNo == roll) {
                it.remove();
                studentVector.remove(s);
                found = true;
                System.out.println("Student removed successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    // Search student
    public void searchStudent(int roll) {
        for (Student s : studentList) {
            if (s.rollNo == roll) {
                System.out.println("\nStudent Found:");
                System.out.println("Roll No: " + s.rollNo);
                System.out.println("Name: " + s.name);
                System.out.println("Marks: " + s.marks);
                return;
            }
        }
        System.out.println("Student not found.");
    }
}

public class StudentRecordApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice;

        try {
            while (true) {

                System.out.println("1. Add Student");
                System.out.println("2. Display All Students");
                System.out.println("3. Remove Student by Roll No");
                System.out.println("4. Search Student by Roll No");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                choice = sc.nextInt();
                sc.nextLine(); // clear buffer

                switch (choice) {

                    case 1:
                        System.out.print("Enter Roll No: ");
                        int roll = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        // REGEX validation for name
                        if (!Pattern.matches("[A-Za-z ]+", name)) {
                            System.out.println("Invalid name! Only alphabets allowed.");
                            break;
                        }

                        System.out.print("Enter Marks: ");
                        int marks = sc.nextInt();

                        manager.addStudent(new Student(roll, name, marks));
                        break;

                    case 2:
                        manager.displayStudents();
                        break;

                    case 3:
                        System.out.print("Enter Roll No to remove: ");
                        int r = sc.nextInt();
                        manager.removeStudent(r);
                        break;

                    case 4:
                        System.out.print("Enter Roll No to search: ");
                        int sr = sc.nextInt();
                        manager.searchStudent(sr);
                        break;

                    case 5:
                        System.out.println("Program exited successfully.");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input!");
        }
    }
}
