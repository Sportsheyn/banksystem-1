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
 * Unpack user arguments and calls the bank method grantcredit()
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

        bank.grantCredit(bankaccountId, amount, new DaoBankaccount(), new DaoCredit());

        System.out.println(feedbackMessage());

    }

    private String feedbackMessage() {
        return "Your credit request was granted.";
    }

    @Override
    public String info() {
        return "Please enter in the following order: bankaccountId, amount.";
    }
}
