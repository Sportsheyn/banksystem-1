package myproject.basic.commands;

import myproject.basic.general.Bank;

import java.util.Map;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

/**
 * The Transfer class is a command. It has the task to transfer money from an account to another.
 */
public class Transfer implements ICommand {

    /**
     * Returns the name of the command
     * @return the name of the command
     */
    @Override
    public String getCommandName() {
        return "transfer";
    }

    /**
     * Transfers money from an account to another.
     *
     * @param bank   - the bank that manages the accounts
     * @param params
     */
    public void execute(Bank bank, Map<String, Object> params) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the amount and the accountnumber.");
        String input = scanner.nextLine();
        String[] text_split = input.split("\\s");

        int sourceaccount = parseInt(text_split[0]);
        int targetaccount = parseInt(text_split[1]);
        double amount = parseDouble(text_split[2]);

        bank.transfer(sourceaccount, targetaccount, amount);
    }
}
