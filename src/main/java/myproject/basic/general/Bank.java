package myproject.basic.general;

import java.util.HashMap;
import java.util.Map;


/**
 * The bank class managed the accounts.
 */
public class Bank {

    /**
     * A constant holding the interest rate (Zinssatz).
     */
    private final int INTEREST_RATE = 4;

    /**
     * A variable that holds the next account number of a new created account.
     */
    private static int next_account_number = 1;

    /**
     * A map holding the created accounts. The key is the account number, the value is the account object.
     */
    private Map<Integer, Account> account_map = new HashMap<>();

    /**
     * The map holding the accounts with a open credit.
     */
    private Map<Integer, Double> credit_overview = new HashMap<>();


    /**
     * The class bank contains methods to create and manage accounts
     */
    public Bank() {

    }

    public Account createAccount(String vorname, String nachname) {
        Account new_account = new Account(vorname, nachname, next_account_number);
        account_map.put(next_account_number, new_account);
        next_account_number++;

        return new_account;
    }

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


    public boolean grantCredit(int sourceaccount, double amount) {

        Account sourceaccount_object = account_map.get(sourceaccount);

        if(sourceaccount_object != null) {

            sourceaccount_object.deposit(amount);
            credit_overview.put(sourceaccount, amount);

            return true;
        }

        return false;
    }


    public boolean repayCredit(int sourceaccount) {

        Account sourceaccount_object = account_map.get(sourceaccount);

        Double amount = credit_overview.get(sourceaccount);

        if(sourceaccount_object != null && amount != null) {

            sourceaccount_object.withdraw(amount);
            credit_overview.remove(sourceaccount);

            return true;
        }

        return false;
    }


    public void payinterest() {

        for (Integer key : credit_overview.keySet()) {

            Double creditAmount = credit_overview.get(key);
            Double creditAmountWithInterest = creditAmount + (creditAmount * INTEREST_RATE / 100);

            credit_overview.put(key, creditAmountWithInterest);
        }

    }




    // ---------------------- Getter and Setter -----------------------------------------------------------------------

    public Map<Integer, Account> getAccount_map() {
        return account_map;
    }

}
