package myproject.basic.general;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Credit {

    private int id;
    private double amount;
    private int debtor;

    public Credit(int debtor, double amount) {
        this.amount = amount;
        this.debtor = debtor;
    }


    // ---------------------- toString --------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Credit{" +
                "id=" + id +
                ", amount=" + amount +
                ", debtor=" + debtor +
                '}';
    }
}
