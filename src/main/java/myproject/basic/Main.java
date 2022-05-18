package myproject.basic;


import myproject.basic.commands.*;
import myproject.basic.general.Bank;
import myproject.basic.helper.Bootstrap;
import myproject.basic.helper.Helper;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public Main() {

    }

    public void start() {

        Bootstrap bootstrap = new Bootstrap();
        Map<String, ICommand> commands = bootstrap.createCommandMap();

        Bank bank = new Bank();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Please enter a command.");
            String input = scanner.nextLine().trim();

            if (input != null) {

                if ("q".equals(input)) break;

                ICommand cmd = commands.get(input.toLowerCase());

                if (cmd != null) {

                    System.out.println(cmd.info());
                    // get the corresponding parameters
                    Map<String, Object> params = Helper.getParams(bank);

                    // check if the needed params are complete and valid

                    try {
                        Bank bankparam = (Bank) params.get("bank");
                        cmd.execute(bankparam, params );

                    } catch (Exception e) {
                        System.out.println(e);
                    }


                } else {
                    System.out.println("Bad command: " + input);
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