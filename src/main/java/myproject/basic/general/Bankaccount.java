package myproject.basic.general;

import lombok.Getter;

/**
 * Representation of an account
 * @author Christopher
 * @version 05.06.2022
 */

@Getter
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

    public void setForename(String forename) {
        this.forename = forename;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }


    // ---------------------- equals and hashCode ---------------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bankaccount that = (Bankaccount) o;

        if (Double.compare(that.amount, amount) != 0) return false;
        if (pin != that.pin) return false;
        if (forename != null ? !forename.equals(that.forename) : that.forename != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = forename != null ? forename.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + pin;
        return result;
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