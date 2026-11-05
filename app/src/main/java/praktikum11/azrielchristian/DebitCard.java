
package praktikum11.azrielchristian;

import java.util.List;

public class DebitCard implements PaymentStrategy {
    private String cardNumber;
    private double balance;
    private String pin;

    public DebitCard(String cardNumber, double balance, String pin) {
        this.cardNumber = cardNumber;
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
            System.out.println("Pembayaran debit berhasil, sisa saldo: " + balance);
        } else {
            System.out.println("Pembayaran gagal. Saldo tidak mencukupi.");
        }
    }

    @Override
    public List<AuthorizationMethod> getRequiredAuthorizations() {
        return List.of(AuthorizationMethod.PIN);
    }

    @Override
    public boolean validateAuthorization(
            AuthorizationMethod method, String credential) {
        return method == AuthorizationMethod.PIN
                && pin.equals(credential);
    }

    @Override
    public boolean canPay(double amount) {
        return amount > 0 && amount <= 10000000;
    }
}
