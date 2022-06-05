package myproject.basic.general;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BankTest {

    @Test
    public void createAccount() {
        Bank bank = new Bank();
        Bankaccount account = bank.createAccount("Hans", "Platner", 1234);

        System.out.println(account.getAccountNumber());

        assertNotNull(account);
    }

    @Test
    public void transfer() {
    }

    @Test
    public void grantCredit() {
        Bank bank = new Bank();
        Bankaccount account = bank.createAccount("Hans", "Platner", 1234);

        bank.grantCredit(account.getAccountNumber(), 500);
        bank.grantCredit(account.getAccountNumber(), 1000);

        List<Double> openCredits = bank.getCreditOverview().get(account.getAccountNumber());
        for(Double credit : openCredits) {
            System.out.print(credit + ", ");
        }

        assertEquals(2, bank.getCreditOverview().get(account.getAccountNumber()).size());

    }

    @Test
    public void repayCredit() {
        Bank bank = new Bank();
        Bankaccount account = bank.createAccount("Hans", "Platner", 1234);

        bank.grantCredit(account.getAccountNumber(), 500);
        bank.grantCredit(account.getAccountNumber(), 1000);

        bank.repayCredit(account.getAccountNumber());

        List<Double> openCredits = bank.getCreditOverview().get(account.getAccountNumber());
        for(Double credit : openCredits) {
            System.out.print(credit + ", ");
        }

        assertEquals(1, bank.getCreditOverview().get(account.getAccountNumber()).size());

    }

    @Test
    public void payinterest() {
    }

    @Test
    public void getAccount_map() {
    }
}