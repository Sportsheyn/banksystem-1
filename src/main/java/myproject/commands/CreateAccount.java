package myproject.commands;

import myproject.general.Account;

import java.util.Scanner;

public class CreateAccount {
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
}
