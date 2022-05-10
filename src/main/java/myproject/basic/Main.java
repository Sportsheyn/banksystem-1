package myproject.basic;

import myproject.basic.commands.CreateAccount;
import myproject.basic.commands.Deposit;
import myproject.basic.commands.Transfer;
import myproject.basic.commands.Withdraw;
import myproject.basic.commands.*;
import myproject.basic.general.Account;
import myproject.basic.general.Bank;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public Main() {

    }

    public void start() {

        Bank bank = new Bank();

        Map<String, ICommand> commands = new HashMap<>();
        commands.put("createaccount", new CreateAccount());
        commands.put("withdraw", new Withdraw());
        commands.put("deposit", new Deposit());
        commands.put("transfer", new Transfer());

        try {
            Class<?> clGrantCredit = Class.forName("myproject.pro.commands.GrantCredit");
            Constructor<?> cGrantCredit = clGrantCredit.getConstructor();
            ICommand oGrantCredit = (ICommand) cGrantCredit.newInstance();
            commands.put(oGrantCredit.getCommandName(), oGrantCredit);
        } catch (Exception ignored) {
            System.out.println(ignored);
        }


        try {
            Class<?> clPayInterest = Class.forName("myproject.pro.commands.PayInterest");
            Constructor<?> cPayInterest = clPayInterest.getConstructor();
            ICommand cmdPayInterest = (ICommand) cPayInterest.newInstance();
            commands.put(cmdPayInterest.getCommandName(), cmdPayInterest);
        } catch (Exception ignored) {
            System.out.println(ignored);
        }

        try {
            Class<?> clRepayCredit = Class.forName("myproject.pro.commands.RepayCredit");
            Constructor<?> cRepayCredit = clRepayCredit.getConstructor();
            ICommand cmdRepayCredit = (ICommand) cRepayCredit.newInstance();
            commands.put(cmdRepayCredit.getCommandName(), cmdRepayCredit);
        } catch (Exception ignored) {
            System.out.println(ignored);
        }


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter a command.");
            String input = scanner.nextLine();
            String[] words = input.split(" ");



            if (words.length > 0) {
                ICommand cmd = commands.get(words[0].toLowerCase());

                if (cmd != null) {
                    Map<String, Object> params = new HashMap<>();

                    params.put("bank", bank);

                    if (words.length > 1) {
                        for (int i = 1; i < words.length; ++i) {
                            params.put("userparam" + i, words[i]);
                        }
                    }

                    try {
                        cmd.execute((Bank) params.get(bank));
                    } catch (Exception ignored) {
                    }

                } else {
                    if ("q".equals(input)) break;
                    else System.out.println("Bad command: " + words[0]);
                }
            }
        }

        System.out.println("Bye...");
        scanner.close();
    }

    public static void main(String[] args){
        Main main = new Main();
        main.start();
        }

}