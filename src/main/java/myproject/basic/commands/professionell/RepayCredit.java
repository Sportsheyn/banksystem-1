package myproject.basic.commands.professionell;

import myproject.basic.commands.ICommand;
import myproject.basic.general.Bank;

import java.util.Map;

import static java.lang.Integer.parseInt;

public class RepayCredit implements ICommand {


    @Override
    public String getCommandName() {
        return "repaycredit";
    }

    @Override
    public void execute(Map<String, Object> params) {
        Bank bank = (Bank) params.get("bank");
        int accountnumber = parseInt((String) params.get("userparam0"));

        bank.repayCredit(accountnumber);
    }

    @Override
    public String info() {
        return "Please enter the accountnumber.";
    }
}
