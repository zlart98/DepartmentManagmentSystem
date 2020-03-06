package com.example.bean;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private String password;
    private List<String> roles;

    public User() {
    }

    public User(String userName, String password, String... roles) {
        this.userName = userName;
        this.password = password;
        this.roles = new ArrayList<String>();
        if (roles != null) {
            for (String r : roles) {
                this.roles.add(r);
            }
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
