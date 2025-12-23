import java.util.*;
import java.util.regex.*;

// Interface
interface EmpWork {
    void addEmp();

    void showEmp();

    void searchEmp();

    void removeEmp();
}

class EmployeeManager implements EmpWork {

    HashMap<String, String> hmap = new HashMap<>();
    Hashtable<String, String> htable = new Hashtable<>();
    TreeMap<String, String> tmap = new TreeMap<>();

    Scanner sc = new Scanner(System.in);

    public void addEmp() {
        try {
            System.out.print("Enter Employee ID (EMP001): ");
            String id = sc.next();

            Pattern p = Pattern.compile("EMP[0-9]{3}");
            Matcher m = p.matcher(id);

            if (!m.matches()) {
                System.out.println("Invalid ID format");
                return;
            }

            System.out.print("Enter Employee Name: ");
            String name = sc.next();

            hmap.put(id, name);
            htable.put(id, name);
            tmap.put(id, name);

            System.out.println("Employee Added Successfully");

        } catch (Exception e) {
            System.out.println("Error while adding employee");
        }
    }

    // Display employees
    public void showEmp() {
        System.out.println("\nHashMap Data: " + hmap);
        System.out.println("Hashtable Data: " + htable);
        System.out.println("TreeMap Data: " + tmap);
    }

    // Search employee
    public void searchEmp() {
        System.out.print("Enter Employee ID to Search: ");
        String id = sc.next();

        if (hmap.containsKey(id)) {
            System.out.println("Employee Name: " + hmap.get(id));
        } else {
            System.out.println("Employee Not Found");
        }
    }

    // Remove employee
    public void removeEmp() {
        System.out.print("Enter Employee ID to Remove: ");
        String id = sc.next();

        hmap.remove(id);
        htable.remove(id);
        tmap.remove(id);

        System.out.println("Employee Removed");
    }

    // Null key and value demo
    void nullDemo() {
        System.out.println("\n--- Null Key & Value Demo ---");

        hmap.put(null, "Rahul");
        hmap.put("EMP999", null);

        System.out.println("HashMap allows null key and value: " + hmap);

        try {
            htable.put(null, "Test"); // Not allowed
        } catch (Exception e) {
            System.out.println("Hashtable does NOT allow null key/value");
        }
    }
}

public class EmployeeMain {
    public static void main(String[] args) {

        EmployeeManager obj = new EmployeeManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1 Add Employee");
            System.out.println("2 Show Employees");
            System.out.println("3 Search Employee");
            System.out.println("4 Remove Employee");
            System.out.println("5 Null Demo");
            System.out.println("6 Exit");

            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    obj.addEmp();
                    break;
                case 2:
                    obj.showEmp();
                    break;
                case 3:
                    obj.searchEmp();
                    break;
                case 4:
                    obj.removeEmp();
                    break;
                case 5:
                    obj.nullDemo();
                    break;
                case 6:
                    System.out.println("Program End");
                    return;
                default:
                    System.out.println("Wrong Choice");
            }
        }
    }
}
