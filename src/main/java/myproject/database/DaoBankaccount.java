package myproject.database;

import myproject.basic.general.Bankaccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DaoBankaccount implements Dao<Bankaccount> {

    private static final String SQL_INSERT = "INSERT INTO BANKACCOUNT (ID, FORENAME, LASTNAME, AMOUNT, PIN) VALUES (?,?,?,?,?)";

    public DaoBankaccount() {
        DbCreateTable.Bankaccount();
    }

    private Connection setUpCon() throws SQLException {
        String user = "user";
        String pass = "password";

        String jdbcUrl = "jdbc:mysql://localhost:3306/myDb";
        String driver = "com.mysql.cj.jdbc.Driver";

        return DriverManager.getConnection(jdbcUrl, user, pass);
    }

    @Override
    public Optional<Bankaccount> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Bankaccount> getAll() {
        return null;
    }

    @Override
    public void save(Bankaccount bankaccount) {
        try (Connection conn = setUpCon();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT))
        {
            preparedStatement.setInt(1, 1000);
            preparedStatement.setString(2, "Christopher");
            preparedStatement.setString(3, "Heyn");
            preparedStatement.setInt(4, 0);
            preparedStatement.setInt(5, 1234);

            preparedStatement.executeUpdate();

        } catch ( Exception e) {

        }
    }

    @Override
    public void update(Bankaccount bankaccount, String[] params) {

    }

    @Override
    public void delete(Bankaccount bankaccount) {

    }

    public static void main(String[] args) {
        Bankaccount bankaccount = new Bankaccount(1000, "Christopher", "Heyn", 1234);
        DaoBankaccount daoBankaccount = new DaoBankaccount();
        daoBankaccount.save(bankaccount);
    }

}
