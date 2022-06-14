package myproject.basic.commands;

import myproject.basic.general.Bankaccount;
import myproject.basic.general.Bank;
import myproject.database.DaoBankaccount;

import java.util.Map;

import static java.lang.Integer.parseInt;

public class GetBalance implements ICommand {

    @Override
    public String getCommandName() {
        return "getbalance";
    }

    @Override
    public void execute(Map<String, Object> params) {
        int bankaccountId = parseInt((String) params.get("userparam1"));

        DaoBankaccount daoBankaccount = new DaoBankaccount();
        Bankaccount bankaccount = daoBankaccount.get(bankaccountId);

        System.out.println(bankaccount);
    }

    @Override
    public String info() {
        return "Please enter your accountnumber and your pin.";
    }
}
