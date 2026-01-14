public class Student implements Comparable<Student> {

    int eno;
    String name;
    String branch;
    String sem;
    double percentage;

    public Student(int eno, String name, String branch, String sem, double percentage) {
        this.eno = eno;
        this.name = name;
        this.branch = branch;
        this.sem = sem;
        this.percentage = percentage;
    }

    @Override
    public int compareTo(Student s) {
        return this.eno - s.eno;
    }

    @Override
    public String toString() {
        return eno + "  " + name + "  " + branch + "  " + sem + "  " + percentage;
    }
}
