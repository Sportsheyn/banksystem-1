package myproject.basic.commands;

import myproject.basic.general.Account;
import myproject.basic.general.Bank;

import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Withdraw {

    public static Account withdraw(Bank bank) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the amount and the accountnumber.");
        String input = scanner.nextLine();
        String[] text_split = input.split("\\s");

        double amount = parseDouble(text_split[0]);
        int accountnumber = parseInt(text_split[1]);

        Account find_account = bank.getAccount_map().get(accountnumber);


        find_account.withdraw(amount);

        return find_account;
    }
}
