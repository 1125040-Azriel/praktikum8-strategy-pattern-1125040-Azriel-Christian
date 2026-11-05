
package praktikum11.azrielchristian;

import java.util.Scanner;

public interface AuthorizationStrategy {
    boolean authorize(Scanner scanner);

    String getName();
}
