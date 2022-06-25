package myproject.basic.commands;

import myproject.basic.general.Bankaccount;
import myproject.basic.general.Bank;
import myproject.database.DaoBankaccount;

import java.util.Map;

import static java.lang.Integer.parseInt;

/**
 * The CreateAccount class is a command. It creates new bankaccount configured from the user input.
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
     * Creates a new bankaccount
     * @param params map with the requested/needed parameters.
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

        Bankaccount bankaccount = bank.createAccount(forename, lastname, pin, new DaoBankaccount());

        System.out.println(feedbackMessage(bankaccount));


    }


    @Override
    public String info() { return "Please enter your forename, lastname and pin."; }

    public String feedbackMessage(Bankaccount bankaccount) {

        return "You have created a new bankaccount. Here the details:\n" +
                "  BankaccountId: " + bankaccount.getId() + "\n" +
                "  Forename: " + bankaccount.getForename() + "\n" +
                "  Lastname: " + bankaccount.getLastname() + "\n" +
                "  Pin: " + bankaccount.getPin();
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