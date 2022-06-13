package myproject.basic.general;

/**
 * Representation of an account
 * @author Christopher
 * @version 05.06.2022
 */

public class Bankaccount {

    private int id;
    private String forename;
    private String lastname;
    private double amount;
    private int pin;


    public Bankaccount(int id, String forename, String lastname, int pin) {
        this.forename = forename;
        this.lastname = lastname;
        this.pin = pin;
    }

    public int getId() {
        return id;
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
                "accountNumber=" + id +
                ", forename='" + forename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", amount=" + amount +
                ", pin=" + pin +
                '}';
    }
}
