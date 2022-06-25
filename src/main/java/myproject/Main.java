package myproject;


import myproject.basic.commands.*;
import myproject.basic.general.Bank;
import myproject.basic.helper.Bootstrap;
import myproject.basic.helper.Helper;
import myproject.database.SetUpConn;

import java.util.HashMap;
import java.util.Map;

public class Main {

    Bank bank;
    Map<String, ICommand> commands;


    public Main() {
        this.bank = new Bank();
        Bootstrap bootstrap = new Bootstrap();
        this.commands = bootstrap.createCommandMap();
    }


    public void start() {

        System.out.println(Helper.welcomeText());

        while (true) {

            System.out.println("Please enter a command.");
            String input = Helper.requestCommand();

            if (input != null) {

                if ("q".equals(input)) break;

                ICommand cmd = commands.get(input.toLowerCase());

                if (cmd != null) {

                    // Check wheater the cmd need a input
                    Map<String, Object> params = null;
                    if (cmd.info() != "") {
                        System.out.println(cmd.info());
                        params = Helper.requestParams(bank);
                    } else {
                        params = new HashMap<>();
                        params.put("bank", bank);
                    }


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
        SetUpConn.close();

    }



    public static void main(String[] args){
        Main main = new Main();
        main.start();
        }

}