package myproject.basic.general;

import javax.persistence.*;

@Entity
public class Credit {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private double amount;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="credits_id")
    private Credits credits;

    public Credit() {
    }

    public Credit(double amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Credits getCredits() {
        return credits;
    }

    public void setCredits(Credits credits) {
        this.credits = credits;
    }
}
