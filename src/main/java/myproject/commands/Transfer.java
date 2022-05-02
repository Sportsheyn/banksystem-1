package myproject.commands;

import myproject.general.Account;

import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Transfer {
    public static boolean transfer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the amount and the accountnumber.");
        String input = scanner.nextLine();
        String[] text_split = input.split("\\s");

        int sourceaccount = parseInt(text_split[0]);
        int targetaccount = parseInt(text_split[1]);
        double amount = parseDouble(text_split[2]);

        Account find_sourceaccount = Account.find_account(sourceaccount);
        Account find_targetaccount = Account.find_account(targetaccount);

        find_sourceaccount.withdraw(amount);
        find_targetaccount.deposit(amount);

        return true;
    }
}
