package myproject.basic.commands;

import myproject.basic.general.Account;
import myproject.basic.general.Bank;
import myproject.database.DbAccount;

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
     * @param bank the bank that manages the accounts
     */
    @Override
    public void execute(Bank bank) {
        if(bank == null) {
            System.out.println("Fuck");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your forename, lastname and pin.");
        String input = scanner.nextLine();
        String[] text_split = input.split("\\s");

        String forename = text_split[0];
        String lastname = text_split[1];
        int pin = parseInt(text_split[2]);

        Account account = bank.createAccount(forename, lastname, pin);

        if (account != null) {
            int accountNr = account.getAccount_number();
            double amount = account.getAmount();
            DbAccount.DbAccountAdd(forename, lastname, accountNr, amount, pin);
        }
    }
}