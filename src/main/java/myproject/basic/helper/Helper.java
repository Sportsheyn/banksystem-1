package myproject.basic.helper;

import myproject.basic.general.Bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Helper {

    private static Scanner scanner = new Scanner(System.in);

    public static Map<String, Object> getParams(Bank bank) {
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
}
