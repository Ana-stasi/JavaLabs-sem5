package application.domain;

import java.util.Objects;
import java.util.UUID;
public class User{
    private UUID id;
    private String role ="guest" ;
    private String username ;
    private String password;
    private String email;
    private boolean enable;

    public User(UUID id, String role, String username, String password, String email, boolean enable) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.password = password;
        this.email = email;
        this.enable = enable;
    }
    public User(String username,boolean enable){
        this.username = username;
        this.enable = enable;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public boolean isEnable() {
        return enable;
    }

    public int getIntRole(){
        int role = 2;
        if(this.role.equals("admin")) role = 1;
        return role;
    }
    public String getRole(){
        return this.role;
    }

    public String getPassword() {
        return password;
    }
    public String  getEnable(){
        String enable = "active";
        if(!this.enable) enable = "blocked";
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return enable == user.enable && Objects.equals(id, user.id)
                && Objects.equals(role, user.role) && Objects.equals(username, user.username)
                && Objects.equals(password, user.password) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, username, password, email, enable);
    }
}
