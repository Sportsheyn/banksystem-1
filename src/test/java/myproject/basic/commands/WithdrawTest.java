package myproject.basic.commands;

import myproject.basic.general.Account;
import myproject.basic.general.Bank;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class WithdrawTest {

    @Test
    public void getCommandName() {
        Withdraw withdraw = new Withdraw();
        assertEquals("withdraw", withdraw.getCommandName());
    }

    @Test
    public void execute() {
        Bank bank = new Bank();
        Account account = bank.createAccount("Tom" , "Gregory", 123);
        account.deposit(1000);

        Map<String, Object> params = new HashMap<>();
        params.put("bank", bank);
        params.put("userparam0", "500");
        params.put("userparam1", Integer.toString(account.getAccountNumber()));

        Withdraw withdraw = new Withdraw();
        withdraw.execute(params);

        assertEquals(500.00, account.getAmount(), 0.001);
    }

    @Test
    public void info() {
        Withdraw withdraw = new Withdraw();
        assertEquals("Please enter the amount and the account number", withdraw.info());
    }

}