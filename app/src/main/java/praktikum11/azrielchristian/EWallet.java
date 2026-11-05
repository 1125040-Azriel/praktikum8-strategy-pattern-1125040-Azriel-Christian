
package praktikum11.azrielchristian;

import java.util.List;

public class EWallet implements PaymentStrategy {

    private String phoneNumber;
    private double balance;
    private String pin;

    public EWallet(String phoneNumber, double balance, String pin) {
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.pin = pin;
    }

    @Override
    public boolean validate(double amount) {
        return amount > 0 && amount <= balance;
    }

    @Override
    public void pay(double amount) {
        if (validate(amount)) {
            balance -= amount;
            System.out.println(
                    "Pembayaran E-Wallet berhasil, sisa saldo: " + balance);
        } else {
            System.out.println("Pembayaran gagal. Saldo tidak mencukupi.");
        }
    }

    @Override
    public List<AuthorizationStrategy> getRequiredAuthorizations() {
        return List.of(
                new PinAuthorization(pin),
                new OtpAuthorization("123456")
        );
    }

    @Override
    public boolean canPay(double amount) {
        return amount > 0 && amount <= balance;
    }
}
