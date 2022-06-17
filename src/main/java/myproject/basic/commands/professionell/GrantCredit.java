package myproject.basic.commands.professionell;


import myproject.basic.commands.ICommand;
import myproject.basic.general.Bank;
import myproject.basic.general.Bankaccount;
import myproject.basic.general.Credit;
import myproject.database.DaoBankaccount;
import myproject.database.DaoCredit;

import java.util.Map;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

/**
 * Middleman between grantCredit() from Bank.class and user input.
 * Grant a credit. Amount and accountnumber hands over the user.
 * The open credit will be saved in the Bank.class. The credit amount will credit to the corresponding account.
 */
public class GrantCredit implements ICommand {

    @Override
    public String getCommandName() {
        return "grantcredit";
    }

    @Override
    public void execute(Map<String, Object> params) {

        Bank bank = (Bank) params.get("bank");
        int bankaccountId = parseInt((String) params.get("userparam0"));
        double amount = parseDouble((String) params.get("userparam1"));

        bank.grantCredit(bankaccountId, amount);


    }

    @Override
    public String info() {
        return "Please enter the accountnumber and the amount.";
    }
}
