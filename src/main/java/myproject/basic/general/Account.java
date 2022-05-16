package myproject.basic.general;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Representation of an account
 * @author Christopher
 * @version 03.05.2022
 */
@Entity
public class Account {

    @Id
    private int account_number;
    private String forename;
    private String lastname;
    private double amount;
    private int pin;


    public Account() {

    }

    public Account(String forename, String lastname, int pin, int account_number) {
        this.forename = forename;
        this.lastname = lastname;
        this.pin = pin;
        this.account_number = account_number;
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
