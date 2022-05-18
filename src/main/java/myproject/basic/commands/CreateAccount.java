package myproject.basic.commands;

import myproject.basic.general.Account;
import myproject.basic.general.Bank;
import myproject.database.DbAccount;

import java.util.Map;
import java.util.Scanner;

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
     *
     * @param bank   the bank that manages the accounts
     * @param params
     */
    @Override
    public void execute(Bank bank, Map<String, Object> params) {

        String forename = (String) params.get("userparam0");
        String lastname = (String) params.get("userparam1");
        int pin = parseInt((String) params.get("userparam2"));

        Account account = bank.createAccount(forename, lastname, pin);
//        if (account != null) {
//            int accountNr = account.getAccount_number();
//            double amount = account.getAmount();
//            DbAccount.DbAccountAdd(forename, lastname, accountNr, amount, pin);
//            System.out.println("Successfully!");
//        }

        System.out.println(successMessage(account));

    }

    @Override
    public String info() { return "Please enter your forename, lastname and pin."; }

    public String successMessage(Account account) {

        return "You have created a new bank account. Your accountnummber is " + account.getAccount_number() + ".";
    }

}