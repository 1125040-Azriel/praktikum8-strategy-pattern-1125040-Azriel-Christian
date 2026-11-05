
package praktikum11.azrielchristian;

public class CreditCard {
    private String cardNumber;
    private double limit;
    private double currentDebt;
    private String ccv;
    private String pin;

    public CreditCard(String cardNumber, double limit, String ccv, String pin) {
        this.cardNumber = cardNumber;
        this.limit = limit;
        this.currentDebt = 0;
        this.ccv = ccv;
        this.pin = pin;
    }

    public boolean validate(double amount) {
        return amount > 0 && amount <= (limit - currentDebt);
    }

    public void pay(double amount) {
        if (validate(amount)) {
            currentDebt += amount;
            System.out.println("Pembayaran credit berhasil, sisa limit: "
                    + (limit - currentDebt));
        } else {
            System.out.println("Pembayaran gagal. Limit kredit tidak mencukupi.");
        }
    }
}
