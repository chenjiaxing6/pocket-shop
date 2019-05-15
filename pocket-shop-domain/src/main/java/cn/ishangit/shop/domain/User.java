package cn.ishangit.shop.domain;

/**
 * @author Chen
 * @create 2019-05-15 16:13
 */
public class User {
    private  String email;
    private  String password;
    private  String username;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
