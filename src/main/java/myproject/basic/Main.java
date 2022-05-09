package myproject.basic;

import myproject.basic.commands.CreateAccount;
import myproject.basic.commands.Deposit;
import myproject.basic.commands.Transfer;
import myproject.basic.commands.Withdraw;
import myproject.basic.commands.*;
import myproject.basic.general.Bank;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            Class<?> clGrantCredit = Class.forName("pro.commands.GrantCredit");
            Constructor<?> cGrantCredit = clGrantCredit.getConstructor();
            Object oGrantCredit = cGrantCredit.newInstance();
            Method mGrantCredit = clGrantCredit.getMethod("grantcredit");
            mGrantCredit.invoke(oGrantCredit);
        } catch (Exception e){}

        try {
            Class<?> clPayInterest = Class.forName("pro.commands.PayInterest");
            Constructor<?> cPayInterest = clPayInterest.getConstructor();
            Object oPayInterest = cPayInterest.newInstance();
            Method mPayInterest = clPayInterest.getMethod("payInterest");
            mPayInterest.invoke(oPayInterest);
        } catch (Exception e){}

        try {
            Class<?> clRepayCredit = Class.forName("pro.commands.RepayCredit");
            Constructor<?> cRepayCredit = clRepayCredit.getConstructor();
            Object oRepayCredit = cRepayCredit.newInstance();
            Method mRepayCredit = clRepayCredit.getMethod("repayCredit");
            mRepayCredit.invoke(oRepayCredit);
        } catch (Exception e){}


        Bank bank = new Bank();
        Map<String, ICommand> commands = new HashMap<>();
        commands.put("createaccount", new CreateAccount());
        commands.put("withdraw", new Withdraw());
        commands.put("deposit", new Deposit());
        commands.put("transfer", new Transfer());


        Scanner scanner = new Scanner(System.in);

        while(true) {

            System.out.println("Please enter a command.");
            String input = scanner.nextLine();
            String[] string_split = input.split("\\s");

            if("q".equals(input)) break;

            if("createaccount".equals(input)) {
                ICommand command = commands.get("createaccount");
                command.execute(bank);
            }

            if("withdraw".equals(input)) {
                ICommand command = commands.get("withdraw");
                command.execute(bank);
            }

            if("deposit".equals(input)) {
                ICommand command = commands.get("deposit");
                command.execute(bank);
            }

            if("transfer".equals(input)) {
                ICommand command = commands.get("transfer");
                command.execute(bank);
            }

        }

        System.out.println("Bye...");
        scanner.close();

    }
}