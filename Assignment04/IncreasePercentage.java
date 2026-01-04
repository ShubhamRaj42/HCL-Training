package Assignment04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class IncreasePercentage {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();

            String updateQuery = "UPDATE Students " +
                    "SET percentage = percentage + (percentage * 0.05) " +
                    "WHERE branch = 'CSE'";

            int rows = stmt.executeUpdate(updateQuery);

            System.out.println(rows + " student(s) percentage increased by 5%");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
