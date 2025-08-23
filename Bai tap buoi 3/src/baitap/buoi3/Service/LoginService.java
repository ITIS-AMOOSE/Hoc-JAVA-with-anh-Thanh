package baitap.buoi3.Service;

import baitap.buoi3.auth.AuthContext;
import baitap.buoi3.auth.UserManager;
import baitap.buoi3.model.User;

import java.util.Scanner;

public class LoginService {
    private final UserManager store;
    public LoginService(UserManager store){ this.store = store; }

    public boolean tryLogin(String username, String password){
        User user = store.find(username);
        if (user != null && user.getPassword().equals(password)) {
            AuthContext.set(user);
            return true;
        }
        return false;
    }

    public void login(Scanner sc){
        System.out.print("Username: "); String u = sc.nextLine().trim();
        System.out.print("Password: "); String p = sc.nextLine().trim();
        if (tryLogin(u,p)) {
            System.out.println("✅ Đăng nhập thành công ("+AuthContext.get().getRole()+")");
        } else {
            System.out.println("❌ Sai tài khoản hoặc mật khẩu.");
        }
    }

    public void logout(){
        if (AuthContext.isLoggedIn()) {
            System.out.println("👋 Tạm biệt " + AuthContext.get().getUsername());
            AuthContext.logout();
        } else {
            System.out.println("Bạn chưa đăng nhập.");
        }
    }
}
