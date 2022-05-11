package myproject.basic;


import myproject.basic.commands.*;
import myproject.basic.general.Bank;

import java.util.HashMap;
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