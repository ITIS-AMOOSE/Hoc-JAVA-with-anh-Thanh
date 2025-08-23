package baitap.buoi3.auth;

import baitap.buoi3.model.Role;
import baitap.buoi3.model.User;

public final class AuthContext {
    private static User current;
    private AuthContext(){}
    public static void set(User u){ current = u; }
    public static User get(){ return current; }
    public static boolean isLoggedIn(){ return current != null; }
    public static boolean isOwner(){ return isLoggedIn() && current.getRole()== Role.OWNER; }
    public static void logout(){ current = null; }
}
