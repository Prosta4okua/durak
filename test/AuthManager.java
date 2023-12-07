import java.util.HashMap;
import java.util.Map;

class AuthManager {
    private Map<String, User> users;

    public AuthManager() {
        this.users = new HashMap<>();
    }

    public boolean registerUser(String username, String password) {
        if (!users.containsKey(username)) {
            User newUser = new User(username, password);
            users.put(username, newUser);
            return true;
        }
        return false;
    }

    public boolean authenticateUser(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }
}