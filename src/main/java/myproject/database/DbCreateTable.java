package myproject.database;

import java.sql.Connection;
import java.sql.Statement;

public class DbCreateTable {

    private static Connection conn = DbsetUp.getConn();

    public static void Bankaccount() {

        try {
            String sqlCreate = "CREATE TABLE IF NOT EXISTS " + "bankaccount"
                    + "  (id            INTEGER NOT NULL AUTO_INCREMENT,"
                    + "   forename      VARCHAR(200),"
                    + "   lastname      VARCHAR(200),"
                    + "   amount        DOUBLE,"
                    + "   pin INTEGER, "
                    + "PRIMARY KEY (id))";

            Statement stmt = conn.createStatement();
            stmt.execute(sqlCreate);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void Credit() {

        try {
            String sqlCreate = "CREATE TABLE IF NOT EXISTS " + "credit"
                    + "  (id            INTEGER NOT NULL AUTO_INCREMENT,"
                    + "   amount      DOUBLE,"
                    + "   debtor      INTEGER,"
                    + "PRIMARY KEY (id))";

            Statement stmt = conn.createStatement();
            stmt.execute(sqlCreate);
        } catch (Exception e) {
            System.out.println(e);
        }

    }


}
