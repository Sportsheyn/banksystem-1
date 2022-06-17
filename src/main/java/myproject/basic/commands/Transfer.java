package myproject.basic.commands;

import myproject.basic.general.Bank;
import myproject.basic.general.Bankaccount;

import java.util.List;
import java.util.Map;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

/**
 * The Transfer class is a command. It has the task to transfer money from an account to another.
 */
public class Transfer implements ICommand {

    /**
     * Returns the name of the command
     * @return the name of the command
     */
    @Override
    public String getCommandName() {
        return "transfer";
    }

    /**
     * Transfers money from an account to another.
     *
     * @param params
     */
    public void execute(Map<String, Object> params) {

        Bank bank = (Bank) params.get("bank");
        int sourceaccount = parseInt((String) params.get("userparam0"));
        int targetaccount = parseInt((String) params.get("userparam1"));
        double amount = parseDouble((String) params.get("userparam2"));

        bank.transfer(sourceaccount, targetaccount, amount);

    }

    @Override
    public String info() {
        return "Please enter in the following order: sourceaccontId, targetaccountId, amount.";
    }


}
