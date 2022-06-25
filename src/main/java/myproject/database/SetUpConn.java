package myproject.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class SetUpConn {

    // Singelton Pattern
    private static Connection conn;


    public SetUpConn() {
    }

    public static Connection getConn() {
        if(conn == null) {
            conn = setUpCon();
        }
        return conn;
    }

    private static Connection setUpCon() {
        try {
            String user = "bank";
            String pass = "1234";

            String jdbcUrl = "jdbc:mysql://localhost:3306/myDb";

            return DriverManager.getConnection(jdbcUrl, user, pass);
        } catch(Exception e) {
            return null;
        }
    }

    public static void close() {
        try {
            conn.close();
        } catch (Exception e) {

        }
    }

}
