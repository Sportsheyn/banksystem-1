package myproject.basic.general;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class AccountTest {

    Account account_01 = new Account("Peter", "Schick");
    Account account_02 = new Account("Sabine", "Rock");


    @Test
    public void getAccount_list() {
        System.out.println("1------");
        System.out.println(account_01.getAccount_number());
        List<Account> accountList = Account.getAccount_list();
        assertEquals(2, accountList.size());
        System.out.println(account_01.getAccount_number());
    }

    @Test //Muss sowas getestet werden?
    public void setAccount_list() {
        System.out.println(account_01.getAccount_number());
        System.out.println("2------");
    }

    @Test
    public void find_account() {
        System.out.println(account_01.getAccount_number());
        Account find_result = Account.find_account(1);
        assertEquals(1, find_result.getAccount_number());
        System.out.println(account_01.getAccount_number());
        System.out.println("3------");
    }

    @Test
    public void getAccount_number() {
        System.out.println(account_01.getAccount_number());
        assertEquals(1, account_01.getAccount_number());
        System.out.println(account_01.getAccount_number());
        System.out.println("4------");
    }

    @Test
    public void deposit() {
        account_01.deposit(5000);
        assertEquals(5000, account_01.getAmount(), 0.001);
    }

    @Test
    public void withdraw() {
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
