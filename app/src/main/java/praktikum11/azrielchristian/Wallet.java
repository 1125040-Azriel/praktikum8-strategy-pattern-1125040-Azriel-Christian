
package praktikum11.azrielchristian;

import java.util.List;

public class Wallet implements PaymentStrategy {
    private String name;
    private double cashValue;

    public Wallet(String name, double cashValue) {
        this.name = name;
        this.cashValue = cashValue;
    }

    @Override
    public boolean validate(double amount) {
        return amount > 0 && amount <= cashValue;
    }

    @Override
    public void pay(double amount) {
        if (validate(amount)) {
            cashValue -= amount;
            System.out.println("Pembayaran cash berhasil, sisa wallet: " + cashValue);
        } else {
            System.out.println("Pembayaran gagal. Saldo tidak mencukupi.");
        }
    }

    @Override
    public List<AuthorizationMethod> getRequiredAuthorizations() {
        return List.of();
    }

    @Override
    public boolean validateAuthorization(
            AuthorizationMethod method, String credential) {
        return false;
    }
}
