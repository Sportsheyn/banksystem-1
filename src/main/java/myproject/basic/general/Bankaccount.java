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


    public Bankaccount() {
    }

    public Bankaccount(String forename, String lastname, int pin) {
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

    // ---------------------- Getter and Setter -----------------------------------------------------------------------

    public void setId(int id) {
        this.id = id;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }


    // ---------------------- toString --------------------------------------------------------------------------------

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
