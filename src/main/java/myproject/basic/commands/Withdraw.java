package myproject.basic.commands;

import myproject.basic.general.Account;

import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Withdraw {
    public static Account withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the amount and the accountnumber.");
        String input = scanner.nextLine();
        String[] text_split = input.split("\\s");

        double amount = parseDouble(text_split[0]);
        int accountnumber = parseInt(text_split[1]);

        Account find_account = Account.find_account(accountnumber);

        find_account.withdraw(amount);

        return find_account;
    }
}
