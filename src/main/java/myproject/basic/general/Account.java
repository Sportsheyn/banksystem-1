package myproject.basic.general;

import java.util.ArrayList;
import java.util.List;


/**
 * Repräsentation eines Bankaccounts
 * @author Christopher
 * @version 03.05.2022
 */
public class Account {

    private String forename;
    private String lastname;
    private int account_number;
    private double amount;
    private int pin;


    public Account(String vorname, String nachname, int account_number) {
        this.account_number = account_number;
        this.forename = vorname;
        this.lastname = nachname;
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
