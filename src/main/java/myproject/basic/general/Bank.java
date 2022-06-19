package myproject.basic.general;

import myproject.database.DaoBankaccount;
import myproject.database.DaoCredit;

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
    private final double INTEREST_RATE = 0.04;


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
        Bankaccount newAccount = new Bankaccount(forename, lastname, pin);

        // ----- Db action -----
        DaoBankaccount daoBankaccount = new DaoBankaccount();
        daoBankaccount.save(newAccount);

        List<Bankaccount> bankaccountList = daoBankaccount.getAll();
        Bankaccount dbBankaccount = null;
        for (int i = 0; i < bankaccountList.size(); i++) {
            Bankaccount bankaccount = bankaccountList.get(i);
            if (bankaccount.getForename().equals(newAccount.getForename()) &&
                bankaccount.getLastname().equals(newAccount.getLastname()) &&
                    bankaccount.getPin() == newAccount.getPin())   {
                dbBankaccount = bankaccount;
            }
        }

        return dbBankaccount;
    }

    /**
     * Tests if a transaction between two accounts was successful.
     * @param sourceaccountId account which will send the money
     * @param targetaccountId account which will receive the money
     * @param amount the amount of the transaction
     * @return true if this transaction between the two accounts was successful false otherwise
     */
    public void transfer(int sourceaccountId, int targetaccountId, double amount) {

        DaoBankaccount daoBankaccount = new DaoBankaccount();
        Bankaccount bankaccountSource = daoBankaccount.get(sourceaccountId);
        Bankaccount bankaccountTarget = daoBankaccount.get(targetaccountId);

        if ( bankaccountSource != null && bankaccountTarget != null) {
            bankaccountSource.withdraw(amount);
            bankaccountTarget.deposit(amount);

            // Db action
            daoBankaccount.update(bankaccountSource);
            daoBankaccount.update(bankaccountTarget);
        }
    }

    /**
     * Tests if a credit was successfully granted from the bank.
     * @param bankaccountId account which request for a credit
     * @param amount the amount of the credit
     * @return true if the credit was granted false otherwise
     */
    public boolean grantCredit(int bankaccountId, double amount) {

        DaoBankaccount daoBankaccount = new DaoBankaccount();
        Bankaccount bankaccount = daoBankaccount.get(bankaccountId);

        bankaccount.deposit(amount);
        daoBankaccount.update(bankaccount);

        Credit credit = new Credit(bankaccountId, amount);

        DaoCredit daoCredit = new DaoCredit();
        daoCredit.save(credit);

        return true;
    }

    /**
     * Tests if a credit was successfully repaid from debitor
     * @param bankaccountId account who has to repay the credit
     * @return true if the credit repayment was successful false otherwise
     */
    public boolean repayCredit(int bankaccountId, int creditId) {

        DaoBankaccount daoBankaccount = new DaoBankaccount();
        Bankaccount bankaccount = daoBankaccount.get(bankaccountId);

        DaoCredit daoCredit = new DaoCredit();
        Credit credit = daoCredit.get(creditId);

        bankaccount.withdraw(credit.getAmount());

        daoBankaccount.save(bankaccount);
        daoCredit.delete(credit);

        return true;
    }

    /**
     *  For all assigned credits the method calculates an interest and adds them to the corresponding account.
     */
    public void payinterest() {

        DaoCredit daoCredit = new DaoCredit();
        List<Credit> creditList = daoCredit.getAll();

        creditList.forEach(credit -> credit.setAmount(credit.getAmount() - (credit.getAmount() * INTEREST_RATE )));
        creditList.forEach(daoCredit::update);

    }


}



