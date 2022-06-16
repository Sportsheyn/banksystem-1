package myproject.basic.commands;

import myproject.basic.general.Bankaccount;
import myproject.basic.helper.Helper;
import myproject.database.DaoBankaccount;

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

        double amount = parseDouble((String) params.get("userparam0"));
        int bankaccountId = parseInt((String)params.get("userparam1"));
        int bankaccountPin = parseInt((String) params.get("userparam2"));

        if(Helper.checkPin(bankaccountId, bankaccountPin)) {
            // ----- Db action -----
            DaoBankaccount daoBankaccount = new DaoBankaccount();
            Bankaccount bankaccount = daoBankaccount.get(bankaccountId);
            bankaccount.deposit(amount);
            daoBankaccount.update(bankaccount);
        }
    }

    @Override
    public String info() {
        return "Please enter in the following order: amount, bankaccountId, pin";
    }

}
