package myproject;

import java.util.Scanner;

public class Main {

    //Test

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Please enter a command.");
            String input = scanner.nextLine();
            String[] string_split = input.split("\\s");

            if(input.equals("q")) break;


            if(input.equals("createaccount")) {
                Account account = Command.createaccount();
                System.out.println(account.getAccount_number());
            }


            if(input.equals("withdraw")) {

                Account account = Command.withdraw();
                System.out.println(account.getAmount());
            }

            if(input.equals("deposit")) {

                Account account = Command.deposit();
                System.out.println(account.getAmount());
            }

            if(input.equals("transfer")) {

                boolean transfer = Command.transfer();
            }

        }

        System.out.println("Bye...");
        scanner.close();

    }
}