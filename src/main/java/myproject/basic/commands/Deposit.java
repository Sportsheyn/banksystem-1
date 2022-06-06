package myproject.basic.commands;

import myproject.basic.general.Bankaccount;
import myproject.basic.general.Bank;

import java.util.Map;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

/**
 * The Deposit class is a command. It deposits money on an account.
 */
public class Deposit implements ICommand {

    /**
     * Returns the name of the command
     * @return the name of the command
     */
    @Override
    public String getCommandName() {
        return "deposit";
    }

    /**
     * Deposits money on an account.
     *
     * @param params
     */
    @Override
    public void execute(Map<String, Object> params) {

        Bank bank = (Bank) params.get("bank");
        double amount = parseDouble((String) params.get("userparam0"));
        int accountnumber = parseInt((String)params.get("userparam1"));

        Bankaccount find_account = bank.getAccountmap().get(accountnumber);

        find_account.deposit(amount);
    }

    @Override
    public String info() {
        return "Please enter the amount and your accountnumber.";
    }

}
