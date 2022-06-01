package myproject.basic.commands;

import myproject.basic.general.Bankaccount;
import myproject.basic.general.Bank;

import java.util.Map;

import static java.lang.Integer.parseInt;

public class GetBalance implements ICommand {

    @Override
    public String getCommandName() {
        return "getbalance";
    }

    @Override
    public void execute(Map<String, Object> params) {

        int accountnumber = parseInt((String) params.get("userparam0"));
        int pin = parseInt((String) params.get("userparam1"));

        Bankaccount findAccount = ((Bank) params.get("bank")).getAccountMap().get(accountnumber);

        if (findAccount != null) {
            System.out.println("Account number: " + accountnumber +"\nAmount: " + findAccount.getAmount());
        }

    }

    @Override
    public String info() {
        return "Please enter your accountnumber and your pin.";
    }
}
