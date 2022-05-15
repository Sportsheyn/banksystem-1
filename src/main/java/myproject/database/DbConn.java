package myproject.database;

import java.sql.*;

public class DbConn {

    Connection myConn;

    public DbConn() {
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", "user", "password");
        } catch(Exception e) {

        }
    }

    public Connection getMyConn() {
        return myConn;
    }

}
