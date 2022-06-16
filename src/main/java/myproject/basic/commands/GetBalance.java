package myproject.basic.commands;

import myproject.basic.general.Bankaccount;
import myproject.basic.helper.Helper;
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
        int bankaccountId = parseInt((String) params.get("userparam0"));
        int bankaccountPin = parseInt((String) params.get("userparam1"));

        if(Helper.checkPin(bankaccountId, bankaccountPin)) {
            // ----- Db action -----
            DaoBankaccount daoBankaccount = new DaoBankaccount();
            Bankaccount bankaccount = daoBankaccount.get(bankaccountId);
            System.out.println(bankaccount);
        } else {
            System.out.println("Sorry, wrong pin.");
        }

    }

    @Override
    public String info() {
        return "Please enter your bankaccountId and your pin.";
    }
}
