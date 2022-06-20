package myproject.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbCreateTable {


    public static Connection setUpConn() throws SQLException {
        String user = "bank";
        String pass = "1234";

        String jdbcUrl = "jdbc:mysql://localhost:3306/myDb";
        String driver = "com.mysql.cj.jdbc.Driver";

        return DriverManager.getConnection(jdbcUrl, user, pass);
    }


    public static void Bankaccount() {

        try(Connection conn = setUpConn()) {
            String sqlCreate = "CREATE TABLE IF NOT EXISTS " + "bankaccount"
                    + "  (id            INTEGER NOT NULL AUTO_INCREMENT,"
                    + "   forename      VARCHAR(200),"
                    + "   lastname      VARCHAR(200),"
                    + "   amount        DOUBLE,"
                    + "   pin INTEGER, "
                    + "PRIMARY KEY (id))";

            Statement stmt = conn.createStatement();
            stmt.execute(sqlCreate);
            System.out.println("Created bankaccount table");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void Credit() {

        try(Connection conn = setUpConn()) {
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
