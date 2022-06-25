package myproject.database;

import myproject.basic.general.Bankaccount;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoBankaccount implements Dao<Bankaccount> {

    private static Connection conn = SetUpConn.getConn();

    private static final String SQL_INSERT = "INSERT INTO BANKACCOUNT (FORENAME, LASTNAME, AMOUNT, PIN) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE BANKACCOUNT SET AMOUNT = ? WHERE ID = ?";
    private static final String SQL_READ = "SELECT * from BANKACCOUNT WHERE ID = ?";
    private static final String SQL_READ_ALL = "SELECT * from BANKACCOUNT";


    public DaoBankaccount() {
        DbCreateTable.Bankaccount();
    }

    @Override
    public Bankaccount get(int id) {

        try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_READ))
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

        try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_READ_ALL))
        {

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Bankaccount> bankaccountList = new ArrayList<>();

            while (resultSet.next()) {

                Bankaccount bankaccount = new Bankaccount();
                bankaccount.setId(resultSet.getInt("id"));
                bankaccount.setForename(resultSet.getString("forename"));
                bankaccount.setLastname(resultSet.getString("lastname"));
                bankaccount.setAmount(resultSet.getDouble("amount"));
                bankaccount.setPin(resultSet.getInt("pin"));

                bankaccountList.add(bankaccount);
            }

            return bankaccountList;

        } catch ( Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void save(Bankaccount bankaccount) {

        try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT))
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

        try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE))
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

}
