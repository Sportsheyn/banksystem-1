package myproject.basic.general;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Credits {

    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name="creditsId")
    private int creditsId;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="credits",  cascade= {CascadeType.ALL})
    private List<Credit> credits;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="bank_id")
    public Bank bank;

    public Credits() {
    }

    public Credits(int id) {
        credits = new ArrayList<>();
        this.creditsId = id;
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public int getCreditsId() {
        return creditsId;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "id=" + creditsId +
                ", credits=" + credits.size() +
                ", bank=" + bank +

                '}';
    }
}
