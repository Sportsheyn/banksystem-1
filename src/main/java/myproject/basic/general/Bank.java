package myproject.basic.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The bank class managed the accounts and supports interaction between them.
 */
public class Bank {

    private int nextAccountNumber;

    /**
     * A map holding the created accounts. The key is the account number, the value is the account object.
     */
    private Map<Integer, Bankaccount> accountMap = new HashMap<>();


    /**
     * A constant holding the interest rate (Zinssatz).
     */
    private final int INTEREST_RATE = 4;


    /**
     * The class bank contains methods to create and manage accounts
     */
    public Bank() {

    }

    /**
     * Returns a new generated account instance
     * @param forename the forename of the account owner
     * @param lastname the lastname of the account owner
     * @return the new generated account
     */
    public Bankaccount createAccount(String forename, String lastname, int pin) {
        int accountNumber = 0;
        Bankaccount newAccount = new Bankaccount(accountNumber, forename, lastname, pin);
        accountMap.put(newAccount.getId(), newAccount);

        return newAccount;
    }

    /**
     * Tests if a transaction between two accounts was successful.
     * @param sourceaccount account which will send the money
     * @param targetaccount account which will receive the money
     * @param amount the amount of the transaction
     * @return true if this transaction between the two accounts was successful false otherwise
     */
    public List<Bankaccount> transfer(int sourceaccount, int targetaccount, double amount) {

        Bankaccount sourceaccount_object = accountMap.get(sourceaccount);
        Bankaccount targetaccount_object = accountMap.get(targetaccount);

        if(sourceaccount_object != null && targetaccount_object != null) {
            sourceaccount_object.withdraw(amount);
            targetaccount_object.deposit(amount);

            List<Bankaccount> accountList = new ArrayList<>();
            accountList.add(sourceaccount_object);
            accountList.add(targetaccount_object);

            return accountList;
        }
        return null;
    }

    /**
     * Tests if a credit was successfully granted from the bank.
     * @param accountid account which request for a credit
     * @param amount the amount of the credit
     * @return true if the credit was granted false otherwise
     */
    public void grantCredit(int accountid, double amount) {
    }

    /**
     * Tests if a credit was successfully repaid from debitor
     * @param sourceaccount account who has to repay the credit
     * @return true if the credit repayment was successful false otherwise
     */
    public boolean repayCredit(int sourceaccount) {
        return false;
    }

    /**
     *  For all assigned credits the method calculates an interest and adds them to the corresponding account.
     */
    public void payinterest() {

    }





    // ---------------------- Getter and Setter -----------------------------------------------------------------------


}



