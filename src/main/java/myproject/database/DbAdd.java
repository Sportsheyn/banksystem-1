package myproject.database;

import java.sql.Connection;
import java.sql.Statement;

public class DbAdd {

    public static boolean DbAdd(Connection conn, int accountnr, int pin) {

        try {
            Statement myStmt = conn.createStatement();
            myStmt.execute(String.format("INSERT INTO Login (Accountnumber, Pin) " +
                    "VALUES (%d, %d)", accountnr, pin));

        } catch (Exception e) {

        }
        return true;
    }

}
