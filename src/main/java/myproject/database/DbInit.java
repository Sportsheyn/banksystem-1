package myproject.database;

import java.sql.Connection;
import java.sql.Statement;

public class DbInit {

    public static void DbInit(Connection conn) {

        try {
            Statement myStmt = conn.createStatement();
            myStmt.execute("CREATE TABLE if not exists Login (Accountnumber int, Pin int)");

        } catch (Exception e) {

        }
    }

}
