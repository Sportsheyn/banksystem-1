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


    public static void main(String[] args) throws SQLException {

        try {
            // 1. Get a connection to database
            Connection myConn = new DbConn().getMyConn();
            DbInit.DbInit(myConn);

            DbAdd.DbAdd(myConn, 2, 9876);



        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
