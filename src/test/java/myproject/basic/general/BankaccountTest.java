package myproject.basic.general;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankaccountTest {

    @Test
    public void deposit() {
        Bankaccount bankaccount = new Bankaccount("Tom", "Cruise", 1234);
        bankaccount.setId(1);
        bankaccount.deposit(500);

        assertEquals(500, bankaccount.getAmount(), 0.0001);
    }

    @Test
    public void withdraw() {
        Bankaccount bankaccount = new Bankaccount("Tom", "Cruise", 1234);
        bankaccount.setId(1);
        bankaccount.deposit(1000);
        bankaccount.withdraw(500);

        assertEquals(500, bankaccount.getAmount(), 0.0001);
    }

}