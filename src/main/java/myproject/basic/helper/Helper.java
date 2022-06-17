package myproject.basic.helper;

import myproject.basic.general.Bank;
import myproject.basic.general.Bankaccount;
import myproject.database.DaoBankaccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Helper {

    private static final Scanner scanner = new Scanner(System.in);

    public static Map<String, Object> requestParams(Bank bank) {
        Map<String, Object> params = new HashMap<>();
        params.put("bank", bank);

        String input = scanner.nextLine();
        String[] inputSplit = input.split(" ");

        if (inputSplit.length > 0) {
            for (int i = 0; i < inputSplit.length; i++) {
                params.put("userparam" + i, inputSplit[i].toLowerCase());
            }
        }
        return params;
    }


    public static String requestCommand() {
        return scanner.nextLine().trim();
    }


    public static String welcomeText() {
        String text = "Welcome to theBank.\n" + "To see all commands, please type 'showcommands'.\n" + "Wiht 'q' you can leave the programm.\n";
        return text;
    }


    public static boolean checkPin(int bankaccountId, int inputPin) {

        // ----- Db action -----
        DaoBankaccount daoBankaccount = new DaoBankaccount();
        Bankaccount bankaccount = daoBankaccount.get(bankaccountId);

        if (bankaccount == null) {
            return false;
        }

        return inputPin == bankaccount.getPin();
    }





}
