package myproject.basic.general;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void getAccount_number() {
        Account account = new Account("Tom", "Gregory", 1);
        assertEquals(1, account.getAccount_number());
    }

    @Test
    public void deposit() {
        Account account = new Account("Tom", "Gregory", 1);
        account.deposit(500.12);
        assertEquals(500.12, account.getAmount(), 0.0001);
    }

    @Test
    public void withdraw() {
        Account account = new Account("Tom", "Gregory", 1);
        account.deposit(500);
        account.withdraw(200);
        assertEquals(300, account.getAmount(), 0.0001);
    }

    @Test
    public void getAmount() {
        Account account = new Account("Tom", "Gregory", 1);
        account.deposit(500);
        account.withdraw(200);
        assertEquals(300, account.getAmount(), 0.0001);
    }

    @Test
    public void setAmount() {
        Account account = new Account("Tom", "Gregory", 1);
        account.setAmount(500);
        assertEquals(500, account.getAmount(), 0.0001);
    }
}