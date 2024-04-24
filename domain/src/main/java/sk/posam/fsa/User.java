package sk.posam.fsa;

public class User {
    private Long id;
    private String name;
    private String userName;
    private String email;
    private Credit credit;
    private UserRole role;

    public User() {
        this.credit = new Credit();
        this.credit.setCount(0);
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
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
