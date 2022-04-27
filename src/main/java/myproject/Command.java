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

    public static Account deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the amount and the accountnumber.");
        String input = scanner.nextLine();
        String[] text_split = input.split("\\s");

        double amount = parseDouble(text_split[0]);
        int accountnumber = parseInt(text_split[1]);

        Account find_account = Account.find_account(accountnumber);

        find_account.deposit(amount);

        return find_account;
    }

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
