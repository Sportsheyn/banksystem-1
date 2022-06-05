package myproject.basic.general;

import javax.persistence.*;

/**
 * Representation of an account
 * @author Christopher
 * @version 03.05.2022
 */
@Entity
public class Bankaccount {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="accountNumber")
    private int accountNumber;

    private String forename;
    private String lastname;
    private double amount;
    private int pin;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="bank_id")
    private Bank bank;

    public Bankaccount() {

    }

    public Bankaccount(String forename, String lastname, int pin) {
        this.forename = forename;
        this.lastname = lastname;
        this.pin = pin;
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

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
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
