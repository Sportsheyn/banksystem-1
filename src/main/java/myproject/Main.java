package myproject;

import myproject.commands.*;
import myproject.general.Account;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Please enter a command.");
            String input = scanner.nextLine();
            String[] string_split = input.split("\\s");

            if(input.equals("q")) break;


            if(input.equals("createaccount")) {
                Account account = CreateAccount.createaccount();
                System.out.println(account.getAccount_number());
            }


            if(input.equals("withdraw")) {

                Account account = Withdraw.withdraw();
                System.out.println(account.getAmount());
            }

            if(input.equals("deposit")) {

                Account account = Deposit.deposit();
                System.out.println(account.getAmount());
            }

            if(input.equals("transfer")) {

                boolean transfer = Transfer.transfer();
            }

        }

        System.out.println("Bye...");
        scanner.close();

    }
}