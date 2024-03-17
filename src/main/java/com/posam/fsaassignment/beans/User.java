package com.posam.fsaassignment.beans;

import java.time.LocalDateTime;

public class User {
    private long id;
    private LocalDateTime created;
    private String name;
    private String userName;

    public User() {

    }

    public long getId() {
        return id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
