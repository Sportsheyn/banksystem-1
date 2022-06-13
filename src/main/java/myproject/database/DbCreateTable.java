package myproject.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbCreateTable {

    public static Connection setUpConn() throws SQLException {
        String user = "user";
        String pass = "password";

        String jdbcUrl = "jdbc:mysql://localhost:3306/myDb";
        String driver = "com.mysql.cj.jdbc.Driver";

        return DriverManager.getConnection(jdbcUrl, user, pass);
    }


    public static void Bankaccount() {

        try(Connection conn = setUpConn()) {
            String sqlCreate = "CREATE TABLE IF NOT EXISTS " + "bankaccount"
                    + "  (id            INTEGER,"
                    + "   forename      VARCHAR(200),"
                    + "   lastname      VARCHAR(200),"
                    + "   amount        INTEGER,"
                    + "   pin INTEGER)";

            Statement stmt = conn.createStatement();
            stmt.execute(sqlCreate);
        } catch (Exception e) {

        }
    }


}
