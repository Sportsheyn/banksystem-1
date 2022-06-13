package myproject;


import myproject.basic.commands.*;
import myproject.basic.general.Bank;
import myproject.basic.helper.Bootstrap;
import myproject.basic.helper.Helper;
import myproject.database.DbBank;

import java.util.Map;
import java.util.Scanner;

public class Main {

    Bank bank;
    Map<String, ICommand> commands;


    public Main() {
        this.bank = DbBank.create();
        Bootstrap bootstrap = new Bootstrap();
        this.commands = bootstrap.createCommandMap();
    }


    public void start() {

        while (true) {

            System.out.println("Please enter a command.");
            String input = Helper.requestCommand();

            if (input != null) {

                if ("q".equals(input)) break;

                ICommand cmd = commands.get(input.toLowerCase());

                if (cmd != null) {

                    System.out.println(cmd.info());
                    Map<String, Object> params = Helper.requestParams(bank);

                    try {
                        cmd.execute(params);

                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("The command could not be executed successfully.");
                    }

                } else {
                    System.out.println("Bad command: " + input);
                }
            }
        }

        System.out.println("Bye...");

    }



    public static void main(String[] args){
        Main main = new Main();
        main.start();
        }

}