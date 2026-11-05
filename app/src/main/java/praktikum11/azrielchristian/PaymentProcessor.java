
package praktikum11.azrielchristian;

import java.util.List;
import java.util.Scanner;

public class PaymentProcessor {

    private Scanner scanner;

    public PaymentProcessor(Scanner scanner) {
        this.scanner = scanner;
    }

    public void processPayment(PaymentStrategy strategy, double amount) {

        if (!strategy.canPay(amount)) {
            System.out.println(
                    "Pembayaran gagal. Nominal tidak sesuai aturan metode pembayaran.");
            return;
        }

        if (!strategy.validate(amount)) {
            System.out.println(
                    "Pembayaran gagal. Saldo atau limit tidak mencukupi.");
            return;
        }

        List<AuthorizationStrategy> requiredAuthorizations =
                strategy.getRequiredAuthorizations();

        for (AuthorizationStrategy authorization : requiredAuthorizations) {

            if (!authorization.authorize(scanner)) {
                System.out.println(
                        "Autentikasi " + authorization.getName()
                        + " gagal. Pembayaran dibatalkan.");
                return;
            }
        }

        strategy.pay(amount);
    }
}
