package myproject;

import java.util.List;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Command {

    public static Account createaccount() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your forename and lastname.");
        String input = scanner.nextLine();
        String[] text_split = input.split("\\s");

        String forename = text_split[0];
        String lastname = text_split[1];

        Account account = new Account(forename, lastname);

        return account;
    }

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
