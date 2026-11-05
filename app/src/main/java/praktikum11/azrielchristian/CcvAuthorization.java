
package praktikum11.azrielchristian;

import java.util.Scanner;

public class CcvAuthorization implements AuthorizationStrategy {

    private String ccv;

    public CcvAuthorization(String ccv) {
        this.ccv = ccv;
    }

    @Override
    public boolean authorize(Scanner scanner) {
        System.out.print("Masukkan CCV: ");
        String input = scanner.nextLine();

        return ccv.equals(input);
    }

    @Override
    public String getName() {
        return "CCV";
    }
}
