package model.entity;

import com.fasterxml.uuid.Generators;

import java.util.UUID;
public class User {
    private UUID id;
    private String role ;
    private String username ;
    private String password;
    private String email;
    private boolean enable;


    public User(String role,String username, String password, String email) {
        this.id = Generators.timeBasedGenerator().generate();
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.enable = true;
    }

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

    public String getUserRole() {

        return role;
    }
    public int getRole(){
        int role = 2;
        if(this.role.equals("admin")) role = 1;
        return role;
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
    public String toString() {
        return String.format("%15s |%35s | %10s",
                username,email,getEnable() );
    }

}
