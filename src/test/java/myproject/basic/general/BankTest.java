package myproject.basic.general;

import myproject.database.DaoBankaccount;
import org.junit.Before;
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