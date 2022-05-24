package myproject.basic.general;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    Bankaccount account;

    @Before
    public void setUp() {
        account = new Bankaccount("Tom", "Gregory", 123, 1);
    }

    @Test
    public void getAccount_number() {
        assertEquals(1, account.getAccountNumber());
    }

    @Test
    public void deposit() {
        account.deposit(500.12);
        assertEquals(500.12, account.getAmount(), 0.0001);
    }

    @Test
    public void withdraw() {
        account.deposit(500);
        account.withdraw(200);
        assertEquals(300, account.getAmount(), 0.0001);
    }

    @Test
    public void getAmount() {
        account.deposit(500);
        account.withdraw(200);
        assertEquals(300, account.getAmount(), 0.0001);
    }

    @Test
    public void setAmount() {
        account.setAmount(500);
        assertEquals(500, account.getAmount(), 0.0001);
    }
}