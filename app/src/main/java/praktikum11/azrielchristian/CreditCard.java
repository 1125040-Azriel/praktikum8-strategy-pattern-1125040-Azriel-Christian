
package praktikum11.azrielchristian;

import java.util.List;

public class CreditCard implements PaymentStrategy {

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

    @Override
    public boolean validate(double amount) {
        return amount > 0 && amount <= (limit - currentDebt);
    }

    @Override
    public void pay(double amount) {
        if (validate(amount)) {
            currentDebt += amount;
            System.out.println(
                    "Pembayaran credit berhasil, total utang: " + currentDebt);
        } else {
            System.out.println("Pembayaran gagal. Limit tidak mencukupi.");
        }
    }

    @Override
    public List<AuthorizationStrategy> getRequiredAuthorizations() {
        return List.of(
                new CcvAuthorization(ccv),
                new PinAuthorization(pin)
        );
    }

    @Override
    public boolean canPay(double amount) {
        return amount >= 100000 && amount <= 100000000;
    }
}
