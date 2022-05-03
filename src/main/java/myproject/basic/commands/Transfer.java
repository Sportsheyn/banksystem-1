package myproject.basic.commands;

import myproject.basic.general.Account;
import myproject.basic.general.Bank;

import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Transfer {
    public static boolean transfer(Bank bank) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the amount and the accountnumber.");
        String input = scanner.nextLine();
        String[] text_split = input.split("\\s");

        int sourceaccount = parseInt(text_split[0]);
        int targetaccount = parseInt(text_split[1]);
        double amount = parseDouble(text_split[2]);

        bank.transfer(sourceaccount, targetaccount, amount);

        return true;
    }
}
