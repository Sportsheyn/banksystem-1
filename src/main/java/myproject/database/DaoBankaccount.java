package myproject.database;

import myproject.basic.general.Bankaccount;

import java.sql.*;
import java.util.List;

public class DaoBankaccount implements Dao<Bankaccount> {

    private static final String SQL_INSERT = "INSERT INTO BANKACCOUNT (FORENAME, LASTNAME, AMOUNT, PIN) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE BANKACCOUNT SET AMOUNT = ? WHERE ID = ?";
    private static final String SQL_READ = "SELECT * from BANKACCOUNT WHERE ID = ?";


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
    public Bankaccount get(int id) {

        try (Connection conn = setUpCon();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_READ))
        {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Bankaccount account = new Bankaccount();
                account.setId(resultSet.getInt("id"));
                account.setForename(resultSet.getString("forename"));
                account.setLastname(resultSet.getString("lastname"));
                account.setAmount(resultSet.getInt("amount"));
                account.setPin(resultSet.getInt("pin"));

                return account;
            }
        } catch ( Exception e) {
            return null;
        }

        return null;
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
            preparedStatement.setString(1, bankaccount.getForename());
            preparedStatement.setString(2, bankaccount.getLastname());
            preparedStatement.setDouble(3, bankaccount.getAmount());
            preparedStatement.setInt(4, bankaccount.getPin());

            preparedStatement.executeUpdate();



        } catch ( Exception e) {

        }
    }

    @Override
    public void update(Bankaccount bankaccount) {

        try (Connection conn = setUpCon();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE))
        {
            preparedStatement.setDouble(1, bankaccount.getAmount());
            preparedStatement.setInt(2, bankaccount.getId());
            preparedStatement.executeUpdate();

        } catch ( Exception e) {
            System.out.println("Error in Class " + DaoBankaccount.class.getName() + " " + e);
        }
    }

    @Override
    public void delete(Bankaccount bankaccount) {

    }

    public static void main(String[] args) {
        DaoBankaccount daoBankaccount = new DaoBankaccount();
        Bankaccount bankaccount = daoBankaccount.get(2);
        System.out.println(bankaccount.toString());
    }
}
