package myproject.basic.general;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The bank class managed the accounts and supports interaction between them.
 */
@Entity
public class Bank {

    /**
     * A variable that holds the next account number of a new created account.
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    /**
     * A map holding the created accounts. The key is the account number, the value is the account object.
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "bank", cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Bankaccount> accountList;

    /**
     * The map holding the accounts with an open credit.
     */
    @ElementCollection
    private Map<Integer, Double> creditOverview = new HashMap<>();

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

        Bankaccount new_account = new Bankaccount(forename, lastname, pin);
        accountList.add(new_account);

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

        Bankaccount sourceaccount_object = accountList.get(sourceaccount);
        Bankaccount targetaccount_object = accountList.get(targetaccount);

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
//        Bankaccount sourceaccount_object = accountMap.get(sourceaccount);
//
//        if(sourceaccount_object != null) {
//
//            if(creditOverview.get(sourceaccount) == null) {
//                sourceaccount_object.deposit(amount);
//                List accountCreditList = new ArrayList<>();
//                accountCreditList.add(amount);
//                creditOverview.put(sourceaccount, accountCreditList);
//            } else {
//                sourceaccount_object.deposit(amount);
//                creditOverview.get(sourceaccount).add(amount);
//            }
//
//            return true;
//        }
        return false;
    }

    /**
     * Tests if a credit was successfully repaid from debitor
     * @param sourceaccount account who has to repay the credit
     * @return true if the credit repayment was successful false otherwise
     */
    public boolean repayCredit(int sourceaccount) {

//        Bankaccount sourceaccount_object = accountMap.get(sourceaccount);
//        List<Double> amount = creditOverview.get(sourceaccount);
//
//        if(sourceaccount_object != null && amount != null) {
//
//            sourceaccount_object.withdraw(amount.get(0));
//            amount.remove(0);
//
//            return true;
//        }

        return false;
    }

    /**
     *  For all assigned credits the method calculates an interest and adds them to the corresponding account.
     */
    public void payinterest() {

//        for (Integer key : creditOverview.keySet()) {
//
//            List<Double> creditList = creditOverview.get(key);
//                for (int i = 0; i < creditList.size(); i++) {
//
//                    Double creditAmountWithInterest = creditList.get(i) + (creditList.get(i) * INTEREST_RATE / 100);
//                    creditList.set(i, creditAmountWithInterest);
//                }
//
//        }
    }

    public void addAccount(Bankaccount account) {
        if (account == null) {
            accountList = new ArrayList<>();
        }
        accountList.add(account);
        account.setBank(this);
    }


    // ---------------------- Getter and Setter -----------------------------------------------------------------------

    /**
     * Returns the map with the existing accounts from the bank.
     * @return a map with all the existing accounts
     */
    public List<Bankaccount> getAccountList() {
        return accountList;
    }

    public Map<Integer, Double> getCreditOverview() {
        return creditOverview;
    }
}
