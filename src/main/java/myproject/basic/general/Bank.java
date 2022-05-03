package myproject.basic.general;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    /**
     * consecutive account_number
     */
    private static int next_account_number = 1;

    private Map<Integer, Account> account_map = new HashMap<>();

    public Bank() {

    }

    public Account createAccount(String vorname, String nachname) {
        Account new_account = new Account(vorname, nachname, next_account_number);
        account_map.put(next_account_number, new_account);
        next_account_number++;

        return new_account;
    }

    /**
     * Überweist einen Betrag von einem Ausgagngskonto auf ein Zielkonto
     * @param sourceaccount Ausgagngskonto, von dem der Betrag abgebucht wird
     * @param targetaccount Eingangskonto, auf dem der Betrag überwiesen wird.
     * @param amount Betrag, der überwiesen werden soll
     * @return
     */
    public boolean transfer(int sourceaccount, int targetaccount, double amount) {

        Account sourceaccount_object = account_map.get(sourceaccount);
        Account targetaccount_object = account_map.get(targetaccount);

        if(sourceaccount_object != null || targetaccount_object != null) {

            sourceaccount_object.withdraw(amount);
            targetaccount_object.deposit(amount);

            return true;
        }

        return false;
    }


    // ---------------------- Getter and Setter -----------------------------------------------------------------------

    public Map<Integer, Account> getAccount_map() {
        return account_map;
    }



}
