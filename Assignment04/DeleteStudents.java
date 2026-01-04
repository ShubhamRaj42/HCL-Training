package Assignment04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteStudents {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            String deleteQuery = "DELETE FROM Students " +
                    "WHERE year_of_passing = 2024 AND branch = 'Civil'";

            int rows = stmt.executeUpdate(deleteQuery);

            System.out.println(rows + " student record(s) deleted successfully");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
