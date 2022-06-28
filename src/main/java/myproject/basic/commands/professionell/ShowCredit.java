package myproject.basic.commands.professionell;

import myproject.basic.commands.ICommand;
import myproject.basic.general.Credit;
import myproject.database.DaoCredit;

import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

/**
 * User arguments are unpacked and open credits are displayed
 */
public class ShowCredit implements ICommand {

    @Override
    public String getCommandName() {
        return "showcredit";
    }

    @Override
    public void execute(Map<String, Object> params) {
        int bankaccountId = parseInt((String) params.get("userparam0"));

        // ----- Db action -----
        DaoCredit daoCredit = new DaoCredit();
        List<Credit> creditList = daoCredit.getAllByDebtor(bankaccountId);

        if (creditList.size() > 0) {
            creditList.forEach(System.out::println);
        } else {
            System.out.println("No open credits to bankaccountId: " + bankaccountId);
        }
    }

    @Override
    public String info() {
        return "Please enter the bankaccountid.";
    }
}
