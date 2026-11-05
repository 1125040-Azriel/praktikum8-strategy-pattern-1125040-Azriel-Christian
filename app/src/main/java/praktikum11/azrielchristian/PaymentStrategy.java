
package praktikum11.azrielchristian;

import java.util.List;

public interface PaymentStrategy {
    boolean validate(double amount);

    void pay(double amount);

    List<AuthorizationStrategy> getRequiredAuthorizations();

    boolean canPay(double amount);
}
