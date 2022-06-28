package myproject.basic.commands.professionell;

import myproject.basic.commands.ICommand;
import myproject.basic.general.Bank;

import java.util.Map;

import static java.lang.Integer.parseInt;

/**
 * Unpack user arguments and calls the bank method repayCredit()
 */
public class RepayCredit implements ICommand {


    @Override
    public String getCommandName() {
        return "repaycredit";
    }

    @Override
    public void execute(Map<String, Object> params) {
        Bank bank = (Bank) params.get("bank");
        int bankaccountId = parseInt((String) params.get("userparam0"));
        int creditId = parseInt((String) params.get("userparam1"));

        bank.repayCredit(bankaccountId, creditId);
    }

    @Override
    public String info() {
        return "Please enter the bankaccountId and creditid.";
    }
}
