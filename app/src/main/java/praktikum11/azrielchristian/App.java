
package praktikum11.azrielchristian;

import java.util.Scanner;

public class App {

    public String getGreeting() {
        return "Dynamic Payment System";
    }

    public static void main(String[] args) {

        Wallet wallet = new Wallet("Wallet Utama", 10000);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(
                "Masukkan jumlah yang dibayar (0 untuk keluar): "
            );

            double amount = scanner.nextDouble();

            if (amount == 0) {
                System.out.println("Program selesai.");
                break;
            }

            wallet.pay(amount);
        }

        scanner.close();
    }
}
