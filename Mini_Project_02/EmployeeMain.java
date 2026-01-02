package Mini_Project_02;

import java.io.*;
import java.util.*;

public class EmployeeMain {

    static ArrayList<Employee> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static File file = new File("emp.txt");

    public static void main(String[] args) {

        login();
        loadFile();

        int ch;
        do {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Display Sorted Employees");
            System.out.println("7. Display Departments");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    addEmp();
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    searchEmp();
                    break;
                case 4:
                    updateSalary();
                    break;
                case 5:
                    deleteEmp();
                    break;
                case 6:
                    sortEmp();
                    break;
                case 7:
                    showDept();
                    break;
                case 8:
                    saveFile();
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        } while (ch != 8);
    }

    // LOGIN
    static void login() {
        System.out.print("Username: ");
        String u = sc.next();
        System.out.print("Password: ");
        String p = sc.next();

        if (!u.equals("admin") || !p.equals("admin123")) {
            System.out.println("Invalid Login");
            System.exit(0);
        }
    }

    // ADD
    static void addEmp() {
        try {
            System.out.print("ID: ");
            int id = sc.nextInt();

            for (Employee e : list) {
                if (e.id == id)
                    throw new Exception("Employee ID already exists");
            }

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Department: ");
            String dept = sc.next();
            if (dept.length() == 0)
                throw new Exception("Department cannot be empty");

            System.out.print("Salary: ");
            double sal = sc.nextDouble();
            if (sal <= 0)
                throw new Exception("Salary must be positive");

            list.add(new Employee(id, name, dept, sal));
            saveFile();
            System.out.println("Employee Added");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // DISPLAY
    static void showAll() {
        if (list.isEmpty()) {
            System.out.println("No records found");
            return;
        }
        for (Employee e : list) {
            System.out.println(e.id + " " + e.name + " " + e.dept + " " + e.salary);
        }
    }

    // SEARCH
    static void searchEmp() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Employee e : list) {
            if (e.id == id) {
                System.out.println(e.id + " " + e.name + " " + e.dept + " " + e.salary);
                return;
            }
        }
        System.out.println("Employee not found");
    }

    // UPDATE
    static void updateSalary() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Employee e : list) {
            if (e.id == id) {
                System.out.print("New Salary: ");
                double s = sc.nextDouble();
                if (s <= 0) {
                    System.out.println("Invalid Salary");
                    return;
                }
                e.salary = s;
                saveFile();
                System.out.println("Salary Updated");
                return;
            }
        }
        System.out.println("Employee not found");
    }

    // DELETE
    static void deleteEmp() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        Iterator<Employee> it = list.iterator();
        while (it.hasNext()) {
            Employee e = it.next();
            if (e.id == id) {
                it.remove();
                saveFile();
                System.out.println("Employee Deleted");
                return;
            }
        }
        System.out.println("Employee not found");
    }

    // SORT
    static void sortEmp() {
        list.sort((a, b) -> a.name.compareTo(b.name));
        showAll();
    }

    // DEPARTMENT
    static void showDept() {
        HashSet<String> set = new HashSet<>();
        for (Employee e : list) {
            set.add(e.dept);
        }
        for (String d : set) {
            System.out.println(d);
        }
    }

    // FILE SAVE
    static void saveFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (Employee e : list) {
                bw.write(e.toString());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("File write error");
        }
    }

    // FILE LOAD
    static void loadFile() {
        try {
            if (!file.exists())
                return;

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String a[] = line.split(",");
                list.add(new Employee(
                        Integer.parseInt(a[0]),
                        a[1],
                        a[2],
                        Double.parseDouble(a[3])));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("File read error");
        }
    }
}
