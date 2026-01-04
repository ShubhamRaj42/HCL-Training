package Assignment04;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnectionDemo {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);

            if (con != null) {
                System.out.println("Connection Successful");
            }

        } catch (Exception e) {
            System.out.println("Unable to connect");
            e.printStackTrace();
        }
    }
}
