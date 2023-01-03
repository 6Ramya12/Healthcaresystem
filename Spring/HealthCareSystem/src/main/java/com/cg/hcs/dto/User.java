package com.cg.hcs.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "user_table")
public class User {
    @Id
    int id;
    @Column(name = "username", length = 20, unique = true)
    String username;
    @Column(name = "password", length = 20)
    String password;
    @Column(name = "role", length = 20)
    String role;

    public User() {
        super();
    }

    public User(int id, String username, String password, String role) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + "]";
    }
}