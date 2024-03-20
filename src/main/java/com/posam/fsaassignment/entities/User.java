package com.posam.fsaassignment.entities;

import com.posam.fsaassignment.enums.UserRole;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime created;
    @Nonnull
    private String name;
    @Column(name = "user_name")
    private String userName;
    @OneToOne(mappedBy = "user")
    private Credit credit;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User() {

    }

    public long getId() {
        return id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @NonNull
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

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
