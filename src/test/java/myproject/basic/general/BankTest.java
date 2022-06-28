package myproject.basic.general;

import myproject.database.DaoBankaccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BankTest {


    @Mock
    DaoBankaccount daoBankaccountMock;

    @Test
    public void createAccount() {

        String forename = "Tom";
        String lastname = "Cruise";
        int pin = 1234;
        Bankaccount newAccount = new Bankaccount(forename, lastname, pin);
        List bankaccountList = new ArrayList();
        bankaccountList.add(newAccount);

        assertNotNull(daoBankaccountMock);
        when(daoBankaccountMock.getAll()).thenReturn(bankaccountList);

        Bank bank = new Bank();
        Bankaccount account = bank.createAccount(forename, lastname, pin, daoBankaccountMock);
        assertEquals("Tom", account.getForename());
        assertEquals("Cruise", account.getLastname());
        assertEquals(1234, account.getPin());
        assertEquals(0, account.getAmount(), 0.001);

    }

    @Test
    public void transfer() {

        String forename1 = "Tom";
        String lastname1 = "Cruise";
        int pin1 = 1234;
        Bankaccount newAccount1 = new Bankaccount(forename1, lastname1, pin1);

        String forename2 = "Tom";
        String lastname2 = "Cruise";
        int pin2 = 1234;
        Bankaccount newAccount2 = new Bankaccount(forename2, lastname2, pin2);

        assertNotNull(daoBankaccountMock);
        when(daoBankaccountMock.get(1)).thenReturn(newAccount1);
        when(daoBankaccountMock.get(2)).thenReturn(newAccount2);

        Bank bank = new Bank();
        bank.transfer(1, 2, 500, daoBankaccountMock);

        assertEquals(-500.0, newAccount1.getAmount(), 0.0001);
        assertEquals(500.0, newAccount2.getAmount(), 0.0001);

    }

    @Test
    public void grantCredit() {

    }

    @Test
    public void repayCredit() {
    }

    @Test
    public void payinterest() {
    }

}