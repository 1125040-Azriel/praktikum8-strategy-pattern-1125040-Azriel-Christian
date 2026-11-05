
package praktikum11.azrielchristian;

import java.util.Scanner;

public class PinAuthorization implements AuthorizationStrategy {

    private String pin;

    public PinAuthorization(String pin) {
        this.pin = pin;
    }

    @Override
    public boolean authorize(Scanner scanner) {
        System.out.print("Masukkan PIN: ");
        String input = scanner.nextLine();

        return pin.equals(input);
    }

    @Override
    public String getName() {
        return "PIN";
    }
}
