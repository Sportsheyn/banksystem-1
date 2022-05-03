package myproject.basic;

import myproject.basic.commands.CreateAccount;
import myproject.basic.commands.Deposit;
import myproject.basic.commands.Transfer;
import myproject.basic.commands.Withdraw;
import myproject.basic.commands.*;
import myproject.basic.general.Account;
import myproject.basic.general.Bank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while(true) {

            System.out.println("Please enter a command.");
            String input = scanner.nextLine();
            String[] string_split = input.split("\\s");

            if(input.equals("q")) break;


            if(input.equals("createaccount")) {

                Account account = CreateAccount.createaccount(bank);
                System.out.println(account.getAccount_number());
            }


            if(input.equals("withdraw")) {

                Account account = Withdraw.withdraw(bank);
                System.out.println(account.getAmount());
            }

            if(input.equals("deposit")) {

                Account account = Deposit.deposit(bank);
                System.out.println(account.getAmount());
            }

            if(input.equals("transfer")) {

                boolean transfer = Transfer.transfer(bank);
            }

        }

        System.out.println("Bye...");
        scanner.close();

    }
}