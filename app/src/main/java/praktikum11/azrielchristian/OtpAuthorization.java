
package praktikum11.azrielchristian;

import java.util.Scanner;

public class OtpAuthorization implements AuthorizationStrategy {

    private String otp;

    public OtpAuthorization(String otp) {
        this.otp = otp;
    }

    @Override
    public boolean authorize(Scanner scanner) {
        System.out.println("Kode OTP (simulasi): " + otp);
        System.out.print("Masukkan OTP: ");
        String input = scanner.nextLine();

        return otp.equals(input);
    }

    @Override
    public String getName() {
        return "OTP";
    }
}
