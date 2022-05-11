package myproject.basic.commands;

import myproject.basic.general.Account;
import myproject.basic.general.Bank;

import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

/**
 * The Deposit class is a command. It deposits money on an account.
 */
public class Deposit implements ICommand {

    /**
     * Returns the name of the command
     * @return the name of the command
     */
    @Override
    public String getCommandName() {
        return "deposit";
    }

    /**
     * Deposits money on an account.
     * @param bank - the bank that manages the accounts
     */
    @Override
    public void execute(Bank bank) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the amount and the accountnumber.");
        String input = scanner.nextLine();
        String[] text_split = input.split("\\s");

        double amount = parseDouble(text_split[0]);
        int accountnumber = parseInt(text_split[1]);

        Account find_account = bank.getAccount_map().get(accountnumber);

        find_account.deposit(amount);
    }
}
