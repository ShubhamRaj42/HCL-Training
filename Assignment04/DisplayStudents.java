package Assignment04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayStudents {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            String selectQuery = "SELECT * FROM Students " +
                    "WHERE semester = 7 AND branch = 'EC'";

            ResultSet rs = stmt.executeQuery(selectQuery);

            System.out.println("ID\tName\tBranch\tSemester\tPercentage");

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println(
                        rs.getInt("id") + "\t" +
                                rs.getString("name") + "\t" +
                                rs.getString("branch") + "\t" +
                                rs.getInt("semester") + "\t\t" +
                                rs.getDouble("percentage"));
            }

            if (!found) {
                System.out.println("No records found");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
