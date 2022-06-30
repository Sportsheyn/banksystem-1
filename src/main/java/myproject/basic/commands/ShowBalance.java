package myproject.basic.commands;

import myproject.basic.general.Bankaccount;
import myproject.basic.helper.Helper;
import myproject.database.DaoBankaccount;

import java.io.PrintWriter;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class ShowBalance implements ICommand {

    @Override
    public String getCommandName() {
        return "showbalance";
    }

    @Override
    public void execute(Map<String, Object> params) {

        PrintWriter out = (PrintWriter) params.get("out");

        int bankaccountId = parseInt((String) params.get("userparam0"));
        int bankaccountPin = parseInt((String) params.get("userparam1"));

        if(Helper.checkPin(bankaccountId, bankaccountPin)) {
            // ----- Db action -----
            DaoBankaccount daoBankaccount = new DaoBankaccount();
            Bankaccount bankaccount = daoBankaccount.get(bankaccountId);
            out.println(bankaccount);
        } else {
            out.println("Sorry, wrong pin.");
        }

    }

    @Override
    public String info() {
        return "Please enter in the following order: bankaccountId, pin.";
    }
}
