package com.example.naty.github;

/**
 * Created by Naty on 27/10/2016.
 */
public class User {
    private String  login;
    private String name;
    private String avatar_url;
    private String email;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
