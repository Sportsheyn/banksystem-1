package myproject.basic.general;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class AccountTest {


    @Test
    public void getAccount_list() {
        Account account_01 = new Account("Peter", "Schick");
        Account account_02 = new Account("Sabine", "Rock");

        List<Account> accountList = Account.getAccount_list();
        assertEquals(2, accountList.size());
    }

    @Test
    public void find_account() {
        Account account_01 = new Account("Peter", "Schick");
        Account account_02 = new Account("Sabine", "Rock");

        Account find_result = Account.find_account(1);
        assertEquals(1, find_result.getAccount_number());
    }

    // Test ist -nicht- unabhängig von den anderen!
    @Test
    public void getAccount_number() {
        Account account_01 = new Account("Peter", "Schick");
        Account account_02 = new Account("Sabine", "Rock");
        assertEquals(5, account_02.getAccount_number());
    }

    @Test
    public void deposit() {
        Account account_01 = new Account("Peter", "Schick");
        account_01.deposit(5000);
        assertEquals(5000, account_01.getAmount(), 0.001);
    }

    @Test
    public void withdraw() {
        Account account_01 = new Account("Peter", "Schick");
        account_01.withdraw(5000);
        assertEquals(-5000, account_01.getAmount(), 0.001);
    }

    @Test
    public void getAmount() {
    }

    @Test
    public void setAmount() {
    }
}
