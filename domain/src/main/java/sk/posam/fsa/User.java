package sk.posam.fsa;

import java.time.LocalDateTime;

public class User {
    private Long id;
    private LocalDateTime created;
    private String name;
    private String userName;
    private String email;
    private Credit credit;
    private UserRole role;

    public User() {
        this.credit = new Credit();
        this.credit.setCount(0);
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

    public Credit getCredit() {
        return credit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
