package lab3.model.entity;

import java.util.UUID;

public class UserSession {
private UUID userId;
    private String username = "guest";
    private String role = "guest";
    private boolean enable = true;
    private static UserSession userSession = new UserSession();

    private UserSession() {
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UUID getUserId() {
        return userId;
    }

    public boolean isEnable() {
        return enable;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public static void setUserSession(UUID userId,String username,String role, boolean enable) {
        userSession.userId=userId;
        userSession.username = username;
        userSession.role = role;
        userSession.enable = enable;
    }
    public static UserSession getUserSession() {
        return userSession;
    }
}
