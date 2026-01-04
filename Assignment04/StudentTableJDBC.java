package Assignment04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StudentTableJDBC {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";

        Connection con = null;
        Statement stmt = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();

            String createTable = "CREATE TABLE IF NOT EXISTS Students ("
                    + "id INT PRIMARY KEY, "
                    + "name VARCHAR(50), "
                    + "age INT, "
                    + "marks DOUBLE)";

            stmt.executeUpdate(createTable);
            System.out.println("Table created successfully");

            String insert1 = "INSERT INTO Students VALUES (1, 'Rahul', 20, 85.5)";
            String insert2 = "INSERT INTO Students VALUES (2, 'Anita', 21, 90.0)";
            String insert3 = "INSERT INTO Students VALUES (3, 'Shubham', 22, 88.0)";

            stmt.executeUpdate(insert1);
            stmt.executeUpdate(insert2);
            stmt.executeUpdate(insert3);

            System.out.println("Records inserted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
