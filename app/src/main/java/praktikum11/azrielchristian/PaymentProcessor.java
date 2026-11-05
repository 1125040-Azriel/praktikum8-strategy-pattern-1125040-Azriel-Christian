
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
            System.out.println("Pembayaran gagal. Nominal tidak sesuai aturan metode pembayaran.");
            return;
        }

        if (!strategy.validate(amount)) {
            System.out.println("Pembayaran gagal. Saldo atau limit tidak mencukupi.");
            return;
        }

        List<AuthorizationMethod> requiredAuthorizations =
                strategy.getRequiredAuthorizations();

        for (AuthorizationMethod method : requiredAuthorizations) {
            System.out.print("Masukkan " + method + ": ");
            String credential = scanner.nextLine();

            if (!strategy.validateAuthorization(method, credential)) {
                System.out.println("Autentikasi gagal. Pembayaran dibatalkan.");
                return;
            }
        }

        strategy.pay(amount);
    }
}
