package myproject.basic.general;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Representation of an account
 * @author Christopher
 * @version 03.05.2022
 */
@Entity
@Table(name="Bankaccount")
public class Bankaccount {

    @Id
    @Column(name="accountNumber")
    private int accountNumber;
    private String forename;
    private String lastname;
    private double amount;
    private int pin;

    public Bankaccount() {

    }

    public Bankaccount(String forename, String lastname, int pin, int account_number) {
        this.forename = forename;
        this.lastname = lastname;
        this.pin = pin;
        this.accountNumber = account_number;
    }

    public int getAccountNumber() {
        return accountNumber;
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

    @Override
    public String toString() {
        return "Bankaccount{" +
                "accountNumber=" + accountNumber +
                ", forename='" + forename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", amount=" + amount +
                ", pin=" + pin +
                '}';
    }
}
