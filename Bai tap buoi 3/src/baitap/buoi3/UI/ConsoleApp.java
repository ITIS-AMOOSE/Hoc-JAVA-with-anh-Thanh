package baitap.buoi3.UI;

import baitap.buoi3.auth.AuthContext;
import baitap.buoi3.auth.UserManager;
import baitap.buoi3.model.ProductBase;
import baitap.buoi3.Seed.Seeder;
import baitap.buoi3.Service.*;

import java.util.List;
import java.util.Scanner;

public class ConsoleApp {

    public static void main(String[] args) {
        List<ProductBase> initial = Seeder.seedProducts();
        ProductService productService = new ProductService(initial);

        LoginService loginService   = new LoginService(new UserManager());
        SearchService searchService = new SearchService(productService);
        ListService listService     = new ListService(productService);
        TableService tableService   = new TableService(productService);
        AddService addService       = new AddService(productService);
        UpdateService updateService = new UpdateService(productService);
        RemoveService removeService = new RemoveService(productService);

        Scanner sc = new Scanner(System.in);

        while (true) {
            showLoginScreen(sc, loginService);

            if (AuthContext.isOwner()) {
                adminMenu(sc, searchService, listService, tableService,
                        addService, updateService, removeService, loginService);
            } else {
                guestMenu(sc, searchService, listService, tableService, loginService);
            }
        }
    }

    private static void showLoginScreen(Scanner sc, LoginService loginService) {
        while (true) {
            System.out.println("\n===== ĐĂNG NHẬP =====");
            System.out.println("(gõ 'q' để thoát)");
            System.out.print("Username: ");
            String u = sc.nextLine().trim();
            if (u.equalsIgnoreCase("q")) { System.out.println("Bye!"); System.exit(0); }
            System.out.print("Password: ");
            String p = sc.nextLine().trim();

            if (loginService.tryLogin(u, p)) {
                System.out.println("✅ Đăng nhập: "
                        + AuthContext.get().getUsername() + " (" + AuthContext.get().getRole() + ")");
                break;
            } else {
                System.out.println("❌ Sai tài khoản hoặc mật khẩu, thử lại.");
            }
        }
    }

    private static void adminMenu(
            Scanner sc,
            SearchService search, ListService list, TableService table,
            AddService add, UpdateService update, RemoveService remove,
            LoginService login) {

        while (AuthContext.isLoggedIn() && AuthContext.isOwner()) {
            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1) Tìm kiếm (bảng/danh sách)");
            System.out.println("2) Xem tất cả - danh sách");
            System.out.println("3) Xem tất cả - bảng");
            System.out.println("4) Thêm sản phẩm");
            System.out.println("5) Cập nhật sản phẩm");
            System.out.println("6) Xoá sản phẩm");
            System.out.println("7) Đăng xuất");
            System.out.println("0) Thoát");
            System.out.print("Chọn: ");
            switch (sc.nextLine().trim()) {
                case "1" -> search.run(sc);
                case "2" -> list.run();
                case "3" -> table.run();
                case "4" -> add.run(sc);
                case "5" -> update.run(sc);
                case "6" -> remove.run(sc);
                case "7" -> { login.logout(); return; }
                case "0" -> { System.out.println("Bye!"); System.exit(0); }
                default -> System.out.println("Không hợp lệ!");
            }
        }
    }

    private static void guestMenu(
            Scanner sc,
            SearchService search, ListService list, TableService table,
            LoginService login) {

        while (AuthContext.isLoggedIn() && !AuthContext.isOwner()) {
            System.out.println("\n===== GUEST MENU =====");
            System.out.println("1) Tìm kiếm (bảng/danh sách)");
            System.out.println("2) Xem tất cả - danh sách");
            System.out.println("3) Xem tất cả - bảng");
            System.out.println("4) Đăng xuất");
            System.out.println("0) Thoát");
            System.out.print("Chọn: ");
            switch (sc.nextLine().trim()) {
                case "1" -> search.run(sc);
                case "2" -> list.run();
                case "3" -> table.run();
                case "4" -> { login.logout(); return; }
                case "0" -> { System.out.println("Bye!"); System.exit(0); }
                default -> System.out.println("Không hợp lệ!");
            }
        }
    }
}
