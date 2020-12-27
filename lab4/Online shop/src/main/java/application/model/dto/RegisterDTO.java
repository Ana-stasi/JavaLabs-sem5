package application.model.dto;

public class RegisterDTO {
    private int role = 2 ;
    private String username ;
    private String password;
    private String email;

    public RegisterDTO(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
