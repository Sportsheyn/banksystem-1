package myproject.basic.general;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representation of a bankaccount
 * @author Christopher
 * @version 05.06.2022
 */
@Setter
@Getter
@NoArgsConstructor
public class Bankaccount {

    private int id;
    private String forename;
    private String lastname;
    private double amount;
    private int pin;

    public Bankaccount(String forename, String lastname, int pin) {
        this.forename = forename;
        this.lastname = lastname;
        this.pin = pin;
    }

    /**
     * deposit the amount to the account
     * @param amount which is used for the transaction
     */
    public void deposit(double amount) {
        this.amount += amount;
    }

    /**
     * withdraws the amount from the account
     * @param amount which is used for the transaction
     */
    public void withdraw(double amount) {
        this.amount -= amount;
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