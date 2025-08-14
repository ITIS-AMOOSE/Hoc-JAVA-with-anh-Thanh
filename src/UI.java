import java.util.Scanner;

public class UI {
    private final Library lib;
    private final Scanner sc;

    public UI(Library lib, Scanner sc) {
        this.lib = lib;
        this.sc = sc;
    }

    public void run() {
        while (true) {
            AuthManager.Role role = AuthManager.login(sc);
            if (role == AuthManager.Role.ADMIN) {
                adminMenu();
            } else {
                guestMenu(false);
            }

            System.out.print("Exit? (y/n): ");
            String exit = sc.nextLine().trim().toLowerCase();
            if (exit.equals("y") || exit.equals("yes")) break;
        }
        System.out.println("Goodbye!");
    }

    private void adminMenu() {
        while (true) {
            System.out.println("=== MENU ADMIN ===");
            System.out.println("1. Add new");
            System.out.println("2. Delete book");
            System.out.println("3. Edit book");
            System.out.println("4. Guest options");
            System.out.println("5. Return to main menu");
            System.out.print("Select an option: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1": lib.add(sc); break;
                case "2": lib.delete(sc); break;
                case "3": lib.edit(sc); break;
                case "4": guestMenu(true); break;
                case "5": return;
                default: System.out.println("Invalid selection.\n");
            }
        }
    }

    private void guestMenu(boolean fromAdmin) {
        while (true) {
            System.out.println(fromAdmin ? "=== MENU GUEST (From AMIN) ===" : "=== MENU GUEST ===");
            System.out.println("1. Search");
            System.out.println("2. Book list");
            System.out.println(fromAdmin ? "3. Return to Admin" : "3. Logout");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1": lib.search(sc); break;
                case "2": lib.list(); break;
                case "3": return;
                default: System.out.println("Invalid.\n");
            }
        }
    }
}
