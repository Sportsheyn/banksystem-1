package myproject.basic.general;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Credit {

    @Id
    @Column(name="id")
    private int id;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "Credits")
    private List<Double> credits;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="bank_id")
    public Bank bank;

    public Credit() {
    }

    public Credit(int id) {
        credits = new ArrayList<>();
        this.id = id;
    }

    public List<Double> getCredits() {
        return credits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
