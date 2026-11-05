package praktikum11.azrielchristian;

public class DebitCard {
    private String cardNumber;
    private double balance;
    private String pin;

    public DebitCard(String cardNumber, double balance, String pin) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.pin = pin;
    }

    public boolean validate(double amount) {
        return amount > 0 && amount <= balance;
    }

    public void pay(double amount) {
        if (validate(amount)) {
            balance -= amount;
            System.out.println("Pembayaran debit berhasil, sisa saldo: " + balance);
        } else {
            System.out.println("Pembayaran gagal. Saldo tidak mencukupi.");
        }
    }
}
