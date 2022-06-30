package myproject.basic.commands;

import myproject.basic.general.Bankaccount;
import myproject.basic.general.Bank;
import myproject.basic.helper.Helper;
import myproject.database.DaoBankaccount;

import java.io.PrintWriter;
import java.util.Map;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

/**
 * The withdraw class is a command. It withdraws money from an account.
 */
public class Withdraw implements ICommand {

    /**
     * Returns the name of the command
     * @return the name of the command
     */
    @Override
    public String getCommandName() {
        return "withdraw";
    }

    /**
     * Withdraws money from an account.
     *
     * @param params
     */
    @Override
    public void execute(Map<String, Object> params) {

        PrintWriter out = (PrintWriter) params.get("out");

        boolean paramsOk = checkInput(params);
        if (!paramsOk) {
            out.println("The input was not valid for the command.");
            return;
        }

        double amount = parseDouble((String) params.get("userparam0"));
        int bankaccountId = parseInt((String) params.get("userparam1"));
        int bankaccountPin = parseInt((String) params.get("userparam2"));


        if(Helper.checkPin(bankaccountId, bankaccountPin)) {
            // ----- Db action -----
            DaoBankaccount daoBankaccount = new DaoBankaccount();
            Bankaccount bankaccount = daoBankaccount.get(bankaccountId);
            bankaccount.withdraw(amount);
            daoBankaccount.update(bankaccount);

            out.println(feedbackMessage(amount));

        } else {
            out.println("Sorry, wrong pin.");
        }
    }

    public String feedbackMessage(double amount) {
        return String.format("Your withdrawal over %f EUR was successful.\n", amount);
    }

    @Override
    public String info() {
        return "Please enter in the following order: amount, bankaccountId, pin.";
    }

    public boolean checkInput(Map<String, Object> params) {

        try {
            double amount = parseDouble((String) params.get("userparam0"));
            int bankaccountId = parseInt((String)params.get("userparam1"));
            int bankaccountPin = parseInt((String) params.get("userparam2"));

        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
