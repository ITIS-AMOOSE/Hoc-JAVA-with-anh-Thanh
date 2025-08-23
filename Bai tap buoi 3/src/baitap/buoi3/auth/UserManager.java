package baitap.buoi3.auth;

import baitap.buoi3.model.Role;
import baitap.buoi3.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private final Map<String, User> users = new HashMap<>();
    public UserManager() {
        users.put("admin", new User("admin","123", Role.OWNER));
        users.put("guest", new User("guest","123", Role.GUEST));
    }
    public User find(String username){ return users.get(username); }
}
