package myproject.basic.commands;

import myproject.basic.general.Bankaccount;
import myproject.basic.general.Bank;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GetBalanceTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void getCommandName() {
        GetBalance getBalanceClass = new GetBalance();
        String commandName = getBalanceClass.getCommandName();
        assertEquals("getbalance", commandName);
    }

    @Test
    public void execute() {
        Bank bank = new Bank();
        Bankaccount account = bank.createAccount("Tom" , "Gregory", 123);
        account.deposit(500);

        Map<String, Object> params = new HashMap<>();
        params.put("bank", bank);
        params.put("userparam0", "1");
        params.put("userparam1", "123");

        GetBalance getBalanceClass = new GetBalance();
        getBalanceClass.execute(params);

        assertEquals("Account number: 1\nAmount: 500.0", outContent.toString().trim());

    }

    @Test
    public void info() {
    }
}