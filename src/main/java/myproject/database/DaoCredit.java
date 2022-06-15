package myproject.database;

import myproject.basic.general.Bankaccount;
import myproject.basic.general.Credit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoCredit implements Dao<Credit> {

    private static final String SQL_INSERT = "INSERT INTO CREDIT (AMOUNT, DEBTOR) VALUES (?,?)";
    private static final String SQL_READ_BY_ID = "SELECT * FROM CREDIT WHERE ID = ?";
    private static final String SQL_READ_ALL_BY_Debtor = "SELECT * FROM CREDIT WHERE DEBTOR = ?";
    private static final String SQL_DELETE = "DELETE FROM CREDIT WHERE ID = ?";
    private static final String SQL_READ_ALL = "SELECT * FROM CREDIT";


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
    public Credit get(int creditId) {

        try (Connection conn = setUpCon();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_READ_BY_ID))
        {
            preparedStatement.setInt(1, creditId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Credit credit = new Credit();
                credit.setId(resultSet.getInt("id"));
                credit.setAmount(resultSet.getDouble("amount"));
                credit.setDebtor((resultSet.getInt("debtor")));

                return credit;
            }

        } catch ( Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public List<Credit> getAll() {
        return null;
    }


    public List<Credit> getAllByDebtor(int debtor) {

        try (Connection conn = setUpCon();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_READ_ALL_BY_Debtor))
        {
            preparedStatement.setInt(1, debtor);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Credit> creditList = new ArrayList<>();

            while (resultSet.next()) {

                Credit credit = new Credit();
                credit.setId(resultSet.getInt("id"));
                credit.setAmount(resultSet.getDouble("amount"));
                credit.setDebtor(resultSet.getInt("debtor"));

                creditList.add(credit);
            }

            return creditList;

        } catch ( Exception e) {
            e.printStackTrace();
        }

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
            e.printStackTrace();
        }

    }

    @Override
    public void update(Credit credit) {

    }

    @Override
    public void delete(Credit credit) {

        try (Connection conn = setUpCon();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_DELETE))
        {
            preparedStatement.setInt(1, credit.getId());

            preparedStatement.executeUpdate();

        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

}
