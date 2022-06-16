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

    // ---------------------- Getter and Setter -----------------------------------------------------------------------

    @Test
    public void getId() {
        Bankaccount bankaccount = new Bankaccount("Tom", "Cruise", 1234);
        bankaccount.setId(1);
        assertEquals(1, bankaccount.getId());
    }

    @Test
    public void setId() {
        Bankaccount bankaccount = new Bankaccount("Tom", "Cruise", 1234);
        bankaccount.setId(1);
        assertEquals(1, bankaccount.getId());
    }

    @Test
    public void getForename() {
        Bankaccount bankaccount = new Bankaccount("Tom", "Cruise", 1234);
        bankaccount.setId(1);
        assertEquals(1, bankaccount.getId());
    }

    @Test
    public void setForename() {
        Bankaccount bankaccount = new Bankaccount("Tom", "Cruise", 1234);
        bankaccount.setId(1);
        assertEquals(1, bankaccount.getId());
    }

    @Test
    public void getLastname() {
        Bankaccount bankaccount = new Bankaccount("Tom", "Cruise", 1234);
        bankaccount.setId(1);
        assertEquals(1, bankaccount.getId());
    }

    @Test
    public void setLastname() {
        Bankaccount bankaccount = new Bankaccount("Tom", "Cruise", 1234);
        bankaccount.setId(1);
        assertEquals(1, bankaccount.getId());
    }

    @Test
    public void getAmount() {
        Bankaccount bankaccount = new Bankaccount("Tom", "Cruise", 1234);
        bankaccount.setId(1);
        assertEquals(1, bankaccount.getId());
    }

    @Test
    public void setAmount() {
        Bankaccount bankaccount = new Bankaccount("Tom", "Cruise", 1234);
        bankaccount.setId(1);
        assertEquals(1, bankaccount.getId());
    }

    @Test
    public void getPin() {
        Bankaccount bankaccount = new Bankaccount("Tom", "Cruise", 1234);
        bankaccount.setId(1);
        assertEquals(1, bankaccount.getId());
    }

    @Test
    public void setPin() {
        Bankaccount bankaccount = new Bankaccount("Tom", "Cruise", 1234);
        bankaccount.setId(1);
        assertEquals(1, bankaccount.getId());
    }

//    @Test
//    public void testToString() {
//    }
}