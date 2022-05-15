package myproject.database;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Locale;

public class DbAccount {

    public static boolean DbAccountAdd(String forename, String lastname, int accountnr, double amount, int pin) {

        try {
            Connection conn = new DbConn().getMyConn();
            DbInit.DbInit(conn);
            Statement myStmt = conn.createStatement();
            String sql = String.format(Locale.US,"INSERT INTO Account (Forename, Lastname, Account_number, Amount, Pin) " +
                    "VALUES ('%s', '%s', %d, %.2f, %d)", forename, lastname, accountnr, amount, pin);
            System.out.println(sql);
            myStmt.execute(sql);

        } catch (Exception e) {
            System.out.println("Error DbAccount");
            System.out.println(e);
        }
        return true;
    }
}
