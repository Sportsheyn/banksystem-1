package myproject.basic.general;

import myproject.database.DbAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The bank class managed the accounts and supports interaction between them.
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
    private Map<Integer, Bankaccount> accountMap = new HashMap<>();

    /**
     * The map holding the accounts with an open credit.
     */
    private Map<Integer, List<Double>> creditOverview = new HashMap<>();

    /**
     * The class bank contains methods to create and manage accounts
     */
    public Bank() {
        initBank();
    }

    private void initBank() {
        List<Bankaccount> accountList = DbAccount.findAll();
        if ( accountList.size() > 0) {

            int highestAccountNumber = 1;

            for(Bankaccount account : accountList) {
                accountMap.put(account.getAccountNumber(), account);

                if (account.getAccountNumber() > highestAccountNumber) {
                    highestAccountNumber = account.getAccountNumber();
                }
            }
            next_account_number = highestAccountNumber + 1;
        }
    }

    /**
     * Returns a new generated account instance
     * @param forename the forename of the account owner
     * @param lastname the lastname of the account owner
     * @return the new generated account
     */
    public Bankaccount createAccount(String forename, String lastname, int pin) {

        Bankaccount new_account = new Bankaccount(forename, lastname, pin, next_account_number);
        accountMap.put(next_account_number, new_account);
        next_account_number++;

        return new_account;
    }

    /**
     * Tests if a transaction between two accounts was successful.
     * @param sourceaccount account which will send the money
     * @param targetaccount account which will receive the money
     * @param amount the amount of the transaction
     * @return true if this transaction between the two accounts was successful false otherwise
     */
    public boolean transfer(int sourceaccount, int targetaccount, double amount) {

        Bankaccount sourceaccount_object = accountMap.get(sourceaccount);
        Bankaccount targetaccount_object = accountMap.get(targetaccount);

        if(sourceaccount_object != null && targetaccount_object != null) {
            sourceaccount_object.withdraw(amount);
            targetaccount_object.deposit(amount);
            return true;
        }
        return false;
    }

    /**
     * Tests if a credit was successfully granted from the bank.
     * @param sourceaccount account which request for a credit
     * @param amount the amount of the credit
     * @return true if the credit was granted false otherwise
     */
    public boolean grantCredit(int sourceaccount, double amount) {

        //get Account
        Bankaccount sourceaccount_object = accountMap.get(sourceaccount);

        if(sourceaccount_object != null) {

            if(creditOverview.get(sourceaccount) == null) {
                sourceaccount_object.deposit(amount);
                List accountCreditList = new ArrayList<>();
                accountCreditList.add(amount);
                creditOverview.put(sourceaccount, accountCreditList);
            } else {
                sourceaccount_object.deposit(amount);
                creditOverview.get(sourceaccount).add(amount);
            }

            return true;
        }
        return false;
    }

    /**
     * Tests if a credit was successfully repaid from debitor
     * @param sourceaccount account who has to repay the credit
     * @return true if the credit repayment was successful false otherwise
     */
    public boolean repayCredit(int sourceaccount) {

        Bankaccount sourceaccount_object = accountMap.get(sourceaccount);
        List<Double> amount = creditOverview.get(sourceaccount);

        if(sourceaccount_object != null && amount != null) {

            sourceaccount_object.withdraw(amount.get(0));
            amount.remove(0);

            return true;
        }

        return false;
    }

    /**
     *  For all assigned credits the method calculates an interest and adds them to the corresponding account.
     */
    public void payinterest() {

        for (Integer key : creditOverview.keySet()) {

            List<Double> creditList = creditOverview.get(key);
                for (int i = 0; i < creditList.size(); i++) {

                    Double creditAmountWithInterest = creditList.get(i) + (creditList.get(i) * INTEREST_RATE / 100);
                    creditList.set(i, creditAmountWithInterest);
                }

        }
    }


    // ---------------------- Getter and Setter -----------------------------------------------------------------------

    /**
     * Returns the map with the existing accounts from the bank.
     * @return a map with all the existing accounts
     */
    public Map<Integer, Bankaccount> getAccountMap() {
        return accountMap;
    }

    public Map<Integer, List<Double>> getCreditOverview() {
        return creditOverview;
    }
}
