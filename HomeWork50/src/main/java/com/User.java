package com;

public class User {
    private String login;
    private String password;
    private String email;
    private String gender;

    public User(String login, String password, String email, String gender) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Login: " + login + "\n" + "Password: " + password + "\n" + "E-mail: " + email + "\n" + "Gender: " + gender;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
