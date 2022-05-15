package myproject.database;

import java.sql.Connection;
import java.sql.Statement;

public class DbInit {

    public static void DbInit(Connection conn) {

        try {
            Statement myStmt = conn.createStatement();
            myStmt.execute("CREATE TABLE if not exists Account (" +
                    "Forename varchar(255), " +
                    "Lastname varchar(255), " +
                    "Account_number int, " +
                    "Amount double, " +
                    "Pin int)");

        } catch (Exception e) {
            System.out.println("DbInit");
            System.out.println(e);
        }
    }
}
