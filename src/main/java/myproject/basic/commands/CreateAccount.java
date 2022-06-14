package myproject.basic.commands;

import myproject.basic.general.Bankaccount;
import myproject.basic.general.Bank;
import myproject.database.DaoBankaccount;

import java.util.Map;

import static java.lang.Integer.parseInt;

/**
 * The CreateAccount class is a command. It creates new Accounts based on the user input.
 */
public class CreateAccount implements ICommand {

    /**
     * Returns the name of the command
     * @return the name of the command
     */
    @Override
    public String getCommandName() {
        return "createaccount";
    }

    /**
     * Creates a new account

     * @param params
     */
    @Override
    public void execute(Map<String, Object> params) {

        boolean paramsOk = checkInput(params);
        if (!paramsOk) {
            System.out.println("The input was not valid for the command.");
            return;
        }

        Bank bank = (Bank) params.get("bank");
        String forename = (String) params.get("userparam0");
        String lastname = (String) params.get("userparam1");
        int pin = parseInt((String) params.get("userparam2"));

        Bankaccount account = bank.createAccount(forename, lastname, pin);

        // ----- Db action -----
        DaoBankaccount daoBankaccount = new DaoBankaccount();
        daoBankaccount.save(account);
    }


    @Override
    public String info() { return "Please enter your forename, lastname and pin."; }

    public String successMessage(Bankaccount account) {

        return "You have created a new bank account. Your accountnummber is " + account.getId() + ".";
    }


    public boolean checkInput(Map<String, Object> params) {

        try {
            String forename = (String) params.get("userparam0");
            String lastname = (String) params.get("userparam1");
            int pin = parseInt((String) params.get("userparam2"));

        } catch (Exception e) {
            return false;
        }

        return true;
    }
}