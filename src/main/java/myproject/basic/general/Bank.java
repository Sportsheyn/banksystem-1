package myproject.basic.general;

import myproject.database.DbBank;
import myproject.database.DbCredit;
import myproject.database.DbCredits;

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
     * A variable that holds the bank id.
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    /**
     * A map holding the created accounts. The key is the account number, the value is the account object.
     */
    @OneToMany(fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "bank_bankaccount_mapping",
            joinColumns = {@JoinColumn(name = "bank_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "bankaccount_id", referencedColumnName = "accountNumber")})
    @MapKey(name = "accountNumber")
    private Map<Integer, Bankaccount> accountMap = new HashMap<>();

    /**
     * The map holding the accounts with an open credit.
     */
    @OneToMany(fetch = FetchType.EAGER, cascade= {CascadeType.ALL}, orphanRemoval=true)
    @JoinTable(name = "bank_credit_mapping",
            joinColumns = {@JoinColumn(name = "bank_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "credits_id", referencedColumnName = "creditsId")})
    @MapKey(name = "creditsId")
    private Map<Integer, Credits> creditOverview = new HashMap<>();

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
        accountMap.put(new_account.getAccountNumber(), new_account);

        return new_account;
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
    public Credits grantCredit(int accountid, double amount) {

        Bankaccount account = accountMap.get(accountid);

        if(account != null) {

            if(creditOverview.get(accountid) == null) {
                Credits credits = new Credits(account.getAccountNumber());
                DbCredits.create(credits);
            }

            Credits credits = DbCredits.read(accountid);
            Credit credit = new Credit(amount);
            credit.setCredits(credits);

            credits.getCredits().add(credit);
            DbCredits.update(credits);

            account.deposit(amount);

            return creditOverview.get(accountid);
        }

        return null;
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
        accountMap.put(account.getAccountNumber(), account);
        account.setBank(this);
    }

    public void addCredits(Credits credits) {
        creditOverview.put(credits.getCreditsId(), credits);
        credits.setBank(this);
    }

    public void removeCredits(int credits) {

        System.out.println("Size " + creditOverview.size());
        Credits c = creditOverview.remove(credits);

        c.setBank(null);
        c.getCredits().clear();

        DbCredits.delete(c);

        System.out.println("Size " + creditOverview.size());
    }

    // ---------------------- Getter and Setter -----------------------------------------------------------------------

    /**
     * Returns the map with the existing accounts from the bank.
     * @return a map with all the existing accounts
     */
    public Map<Integer, Bankaccount> getAccountmap() {
        return accountMap;
    }


    public Map<Integer, Credits> getCreditOverview() {
        return creditOverview;
    }



    public static void main(String[] args) {

//        Bank bank = DbBank.read();
//        bank.removeCredits(1240);
        Credits credits = DbCredits.read(1241);
        List<Credit> credits1 = credits.getCredits();
        System.out.println(credits1.size());
        credits1.stream().forEach(System.out::println);
        //credits1.stream().forEach(c -> DbCredit.delete(c));



    }

}



