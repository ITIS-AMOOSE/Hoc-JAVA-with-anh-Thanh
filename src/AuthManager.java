import java.util.Locale;
import java.util.Scanner;

public class AuthManager {
    public enum Role {
        ADMIN, GUEST
    }

    public static Role login(Scanner sc) {
        System.out.println("=== LOGIN ===");
        System.out.print("Account (admin / guest): ");
        String user = sc.nextLine().trim().toLowerCase(Locale.ROOT);

        if (user.equals("admin")) {
            System.out.print("password: ");
            String pass = sc.nextLine().trim();
            if (pass.equals("admin")) {
                System.out.println(">> Login successfully.\n");
                return Role.ADMIN;
            } else {
                System.out.println(">> Wrong password. Return to GUEST.\n");
                return Role.GUEST;
            }
        }
        if (user.equals("guest")) {
            System.out.println(">> Login without password.\n");
            return Role.GUEST;
        }
        System.out.println(">> Turn into GUEST.\n");
        return Role.GUEST;
    }
}