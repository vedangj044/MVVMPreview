package com.vedangj044.mvvmpreview;

public class RegisterModel {

    private String username;
    private String name;
    private String password;
    private String repassword;

    public RegisterModel(String username, String name, String password, String repassword) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.repassword = repassword;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
