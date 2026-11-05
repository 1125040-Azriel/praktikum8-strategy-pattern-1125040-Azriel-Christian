package praktikum11.azrielchristian;

public class Wallet {
    private String name;
    private double cashValue;

    public Wallet(String name, double cashValue) {
        this.name = name;
        this.cashValue = cashValue;
    }

    public boolean validate(double amount) {
        return amount > 0 && amount <= cashValue;
    }

    public void pay ( double amount) {
        if ( validate(amount)) {
            cashValue -= amount;

            System.err.println("pembayaran cash berhasil, sisa wallet: " + cashValue);
        } else {
            System.err.println("Pembayaran gagal. Saldo tidak mencukupi.");
        }
    }
}
