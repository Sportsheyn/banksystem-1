package myproject;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private static int next_account_number = 1;
    private static ArrayList<Account> account_list = new ArrayList<>();

    public static ArrayList<Account> getAccount_list() {
        return account_list;
    }

    public static void setAccount_list(ArrayList<Account> account_list) {
        Account.account_list = account_list;
    }

    public static Account find_account(int search_number) {
        List<Account> account_list = getAccount_list();

        for (int i = 0; i < account_list.size(); i++) {
            if(search_number == getAccount_list().get(i).getAccount_number()) {
                return  getAccount_list().get(i);
            }
        }
        return null;
    }

    private static boolean transfer(int sourceaccount, int targetaccount, double amount) {

        Account sourceaccount_object = null;
        Account targetaccount_object = null;

        for (int i = 0; i < account_list.size(); i++) {
            Account account_item = account_list.get(i);
            int account_number = account_item.getAccount_number();

            if(sourceaccount == account_number) {
                sourceaccount_object = account_item;
            } else if (targetaccount == account_number) {
                targetaccount_object = account_item;
            }
        }

        if(sourceaccount_object != null || targetaccount_object != null) {

            sourceaccount_object.setAmount(sourceaccount_object.getAmount() - amount);
            targetaccount_object.setAmount(sourceaccount_object.getAmount() + amount);

            return true;
        }

        return false;
    }




    private String forename;
    private String lastname;
    private int account_number;
    private double amount;
    private int pin;



    public Account(String vorname, String nachname) {
        account_number = next_account_number;
        next_account_number++;

        this.forename = vorname;
        this.lastname = nachname;
        account_list.add(this);
    }

    public int getAccount_number() {
        return account_number;
    }

    public void deposit(double amount) {
        this.amount += amount;
    }

    public void withdraw(double amount) {
        this.amount -= amount;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
