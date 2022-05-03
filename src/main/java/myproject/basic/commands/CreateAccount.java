package myproject.basic.commands;

import myproject.basic.general.Account;
import myproject.basic.general.Bank;

import java.util.Scanner;

public class CreateAccount {
    public static Account createaccount(Bank bank) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your forename and lastname.");
        String input = scanner.nextLine();
        String[] text_split = input.split("\\s");

        String forename = text_split[0];
        String lastname = text_split[1];

        Account account = bank.createAccount(forename, lastname);

        return account;
    }
}
