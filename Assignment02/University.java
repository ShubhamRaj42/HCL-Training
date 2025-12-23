import java.util.*;
import java.util.regex.*;


interface UniWork {
    void addStu();

    void showStu();

    void searchStu();

    void removeStu();
}


class Student {
    String id;
    String name;
    String course;
    int marks;

    Student(String id, String name, String course, int marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public String toString() {
        return id + " " + name + " " + course + " " + marks;
    }
}

class UniManage implements UniWork {
    ArrayList<Student> al = new ArrayList<>();
    Vector<Student> v = new Vector<>();
    Stack<Student> st = new Stack<>();
    HashMap<String, Student> hmap = new HashMap<>();
    Hashtable<String, Student> htable = new Hashtable<>();
    TreeMap<String, Student> tmap = new TreeMap<>();

    Set<String> courseSet = new HashSet<>();

    Scanner sc = new Scanner(System.in);

    // Add student
    public void addStu() {
        try {
            System.out.print("Enter Student ID (STU001): ");
            String id = sc.next();
            Pattern p = Pattern.compile("STU[0-9]{3}");
            Matcher m = p.matcher(id);

            if (!m.matches()) {
                System.out.println("Wrong ID format");
                return;
            }

            if (hmap.containsKey(id)) {
                System.out.println("Duplicate Student ID not allowed");
                return;
            }

            System.out.print("Enter Name: ");
            String name = sc.next();

            System.out.print("Enter Course: ");
            String course = sc.next();

            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();

            Student s = new Student(id, name, course, marks);

            al.add(s);
            v.add(s);
            st.push(s);

            hmap.put(id, s);
            htable.put(id, s);

            courseSet.add(course);

            System.out.println("Student Added");

        } catch (Exception e) {
            System.out.println("Error while adding student");
        }
    }

    // Show students
    public void showStu() {
        System.out.println("\nStudent List:");
        for (Student s : al) {
            System.out.println(s);
        }
    }

    // Search student
    public void searchStu() {
        System.out.print("Enter Student ID: ");
        String id = sc.next();

        if (hmap.containsKey(id)) {
            System.out.println(hmap.get(id));
        } else {
            System.out.println("Student Not Found");
        }
    }

    // Remove student
    public void removeStu() {
        System.out.print("Enter Student ID to Remove: ");
        String id = sc.next();

        Student s = hmap.remove(id);

        if (s != null) {
            al.remove(s);
            v.remove(s);
            st.remove(s);
            htable.remove(id);
            System.out.println("Student Removed");
        } else {
            System.out.println("Student Not Found");
        }
    }

    // Sort by marks
    void sortByMarks() {
        Collections.sort(al, (a, b) -> b.marks - a.marks);
        System.out.println("Sorted by Marks");
        showStu();
    }

    // Convert HashMap to TreeMap
    void convertMap() {
        tmap.putAll(hmap);
        System.out.println("TreeMap Data (Sorted):");
        System.out.println(tmap);
    }

    // Count students course-wise
    void countCourse() {
        Map<String, Integer> countMap = new HashMap<>();

        for (Student s : al) {
            countMap.put(s.course, countMap.getOrDefault(s.course, 0) + 1);
        }

        System.out.println("Course Wise Count: " + countMap);
    }

    // Show unique courses
    void showCourse() {
        System.out.println("All Courses:");
        for (String c : courseSet) {
            System.out.println(c);
        }
    }
}


public class University {
    public static void main(String[] args) {

        UniManage obj = new UniManage();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1 Add Student");
            System.out.println("2 Show Students");
            System.out.println("3 Search Student");
            System.out.println("4 Remove Student");
            System.out.println("5 Sort by Marks");
            System.out.println("6 Convert HashMap to TreeMap");
            System.out.println("7 Count Course-wise");
            System.out.println("8 Show Courses");
            System.out.println("9 Exit");

            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    obj.addStu();
                    break;
                case 2:
                    obj.showStu();
                    break;
                case 3:
                    obj.searchStu();
                    break;
                case 4:
                    obj.removeStu();
                    break;
                case 5:
                    obj.sortByMarks();
                    break;
                case 6:
                    obj.convertMap();
                    break;
                case 7:
                    obj.countCourse();
                    break;
                case 8:
                    obj.showCourse();
                    break;
                case 9:
                    System.out.println("Program End");
                    return;
                default:
                    System.out.println("Wrong Choice");
            }
        }
    }
}
