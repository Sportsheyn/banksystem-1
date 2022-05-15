package myproject.database;

import java.sql.Connection;
import java.sql.SQLException;

public class Dbtest {

    public static void main(String[] args) throws SQLException {

        try {
            // 1. Get a connection to database
            Connection myConn = new DbConn().getMyConn();
            // 2. Create Tables
            DbInit.DbInit(myConn);

            // DbAdd.DbAdd(myConn, 2, 9876);



        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
