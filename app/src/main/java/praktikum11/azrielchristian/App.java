
package praktikum11.azrielchristian;

import java.util.Scanner;

public class App {

    public String getGreeting() {
        return "Dynamic Payment System";
    }

    public static void main(String[] args) {
        Wallet wallet = new Wallet("Wallet Utama", 10000);

        DebitCard debitCard = new DebitCard(
            "1234567890",
            100000,
            "1234"
        );

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Masukkan jumlah yang dibayar (0 untuk keluar): ");
            double amount = scanner.nextDouble();

            if (amount == 0) {
                System.out.println("Program selesai.");
                break;
            }

            System.out.println("Pilih metode pembayaran:");
            System.out.println("1. Cash");
            System.out.println("2. Debit");
            System.out.print("Pilihan: ");

            int pilihan = scanner.nextInt();

            if (pilihan == 1) {
                wallet.pay(amount);
            } else if (pilihan == 2) {
                debitCard.pay(amount);
            } else {
                System.out.println("Pilihan metode pembayaran tidak valid.");
            }

            System.out.println();
        }

        scanner.close();
    }
}
