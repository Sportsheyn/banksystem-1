package myproject.database;

import myproject.basic.general.Credit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DaoCredit implements Dao<Credit> {

    private static final String SQL_INSERT = "INSERT INTO CREDIT (AMOUNT, DEBTOR) VALUES (?,?)";


    public DaoCredit() {
        DbCreateTable.Credit();
    }

    private Connection setUpCon() throws SQLException {
        String user = "user";
        String pass = "password";

        String jdbcUrl = "jdbc:mysql://localhost:3306/myDb";
        String driver = "com.mysql.cj.jdbc.Driver";

        return DriverManager.getConnection(jdbcUrl, user, pass);
    }

    @Override
    public Credit get(int id) {
        return null;
    }

    @Override
    public List<Credit> getAll() {
        return null;
    }

    @Override
    public void save(Credit credit) {

        try (Connection conn = setUpCon();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT))
        {
            preparedStatement.setDouble(1, credit.getAmount());
            preparedStatement.setInt(2, credit.getDebtor());

            preparedStatement.executeUpdate();

        } catch ( Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void update(Credit credit) {

    }

    @Override
    public void delete(Credit credit) {

    }


}
