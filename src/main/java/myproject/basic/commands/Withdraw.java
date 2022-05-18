package myproject.basic.commands;

import myproject.basic.general.Account;
import myproject.basic.general.Bank;

import java.util.Map;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

/**
 * The Withdraw class is a command. It withdraws money from an account.
 */
public class Withdraw implements ICommand {

    /**
     * Returns the name of the command
     * @return the name of the command
     */
    @Override
    public String getCommandName() {
        return "withdraw";
    }

    /**
     * Withdraws money from an account.
     *
     * @param params
     */
    @Override
    public void execute(Map<String, Object> params) {

        Bank bank = (Bank) params.get("bank");
        double amount = parseDouble((String) params.get("userparam0"));
        int accountnumber = parseInt((String) params.get("userparam1"));

        Account find_account = bank.getAccount_map().get(accountnumber);
        find_account.withdraw(amount);
    }

    @Override
    public String info() {
        return "Please enter the amount and the account number";
    }
}
