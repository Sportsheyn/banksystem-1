package myproject.pro.commands;


import myproject.basic.commands.ICommand;
import myproject.basic.general.Bank;

import java.util.Map;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

/**
 * Gewährt einen Kredit vom Umfang <amount> und merkt sich, dass ein solcher Kredit für das Konto besteht.
 * Dem Konto wird der Betrag <amount> gutgeschrieben.
 */
public class GrantCredit implements ICommand {

    @Override
    public String getCommandName() {
        return "grantcredit";
    }

    @Override
    public void execute(Map<String, Object> params) {

        Bank bank = (Bank) params.get("bank");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the amount and the accountnumber.");
        String input = scanner.nextLine();
        String[] text_split = input.split("\\s");

        double amount = parseDouble(text_split[0]);
        int accountnumber = parseInt(text_split[1]);

        bank.grantCredit(accountnumber, amount);
    }

    @Override
    public String info() {
        return null;
    }
}
