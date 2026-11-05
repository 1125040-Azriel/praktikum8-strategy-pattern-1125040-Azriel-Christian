package praktikum11.azrielchristian;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public String getGreeting() {
        return "Dynamic Payment System";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<PaymentStrategy> paymentMethods = new ArrayList<>();
        ArrayList<String> paymentNames = new ArrayList<>();

        PaymentProcessor processor = new PaymentProcessor(scanner);

        // Metode pembayaran awal
        paymentMethods.add(new Wallet("Wallet Utama", 10000));
        paymentNames.add("Wallet Utama");

        int menu;

        do {
            System.out.println("\n=== DYNAMIC PAYMENT SYSTEM ===");
            System.out.println("1. Bikin Pembayaran");
            System.out.println("2. Tambah Pembayaran");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            menu = scanner.nextInt();
            scanner.nextLine();

            if (menu == 1) {
                System.out.print("Masukkan jumlah yang dibayar: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("\nPilih metode pembayaran:");

                ArrayList<Integer> availableMethods = new ArrayList<>();

                // Menampilkan metode yang sesuai dengan nominal
                for (int i = 0; i < paymentMethods.size(); i++) {
                    PaymentStrategy strategy = paymentMethods.get(i);

                    if (strategy.canPay(amount)) {
                        availableMethods.add(i);

                        System.out.println(availableMethods.size() + ". "
                                + paymentNames.get(i));
                    }
                }

                if (availableMethods.isEmpty()) {
                    System.out.println(
                            "Tidak ada metode pembayaran yang sesuai.");
                    continue;
                }

                System.out.print("Pilihan: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                if (pilihan < 1 || pilihan > availableMethods.size()) {
                    System.out.println("Pilihan tidak valid.");
                    continue;
                }

                PaymentStrategy strategy =
                        paymentMethods.get(availableMethods.get(pilihan - 1));

                processor.processPayment(strategy, amount);

            } else if (menu == 2) {
                System.out.println("\n=== TAMBAH PEMBAYARAN ===");
                System.out.println("1. Cash / Wallet");
                System.out.println("2. Debit Card");
                System.out.println("3. Credit Card");
                System.out.print("Pilih jenis pembayaran: ");

                int jenis = scanner.nextInt();
                scanner.nextLine();

                if (jenis == 1) {
                    System.out.print("Masukkan nama wallet: ");
                    String name = scanner.nextLine();

                    System.out.print("Masukkan saldo wallet: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine();

                    paymentMethods.add(new Wallet(name, balance));
                    paymentNames.add(name);

                    System.out.println("Wallet berhasil ditambahkan.");

                } else if (jenis == 2) {
                    System.out.print("Masukkan nomor kartu: ");
                    String cardNumber = scanner.nextLine();

                    System.out.print("Masukkan saldo debit: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Masukkan PIN: ");
                    String pin = scanner.nextLine();

                    paymentMethods.add(
                            new DebitCard(cardNumber, balance, pin));
                    paymentNames.add("Debit Card " + cardNumber);

                    System.out.println("Debit Card berhasil ditambahkan.");

                } else if (jenis == 3) {
                    System.out.print("Masukkan nomor kartu: ");
                    String cardNumber = scanner.nextLine();

                    System.out.print("Masukkan limit kartu: ");
                    double limit = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Masukkan CCV: ");
                    String ccv = scanner.nextLine();

                    System.out.print("Masukkan PIN: ");
                    String pin = scanner.nextLine();

                    paymentMethods.add(
                            new CreditCard(cardNumber, limit, ccv, pin));
                    paymentNames.add("Credit Card " + cardNumber);

                    System.out.println("Credit Card berhasil ditambahkan.");

                } else {
                    System.out.println("Jenis pembayaran tidak valid.");
                }

            } else if (menu == 0) {
                System.out.println("Terima kasih telah menggunakan sistem.");

            } else {
                System.out.println("Menu tidak valid.");
            }

        } while (menu != 0);

        scanner.close();
    }
}