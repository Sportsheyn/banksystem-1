package myproject.basic.general;

public class Credit {

    private int id;
    private double amount;
    private int debtor;


    public Credit() {
    }

    public Credit(int debtor, double amount) {
        this.amount = amount;
        this.debtor = debtor;
    }


    // ---------------------- Getter and Setter -----------------------------------------------------------------------

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

    public int getDebtor() {
        return debtor;
    }

    public void setDebtor(int debtor) {
        this.debtor = debtor;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "id=" + id +
                ", amount=" + amount +
                ", debtor=" + debtor +
                '}';
    }
}
