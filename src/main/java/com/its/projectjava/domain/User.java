package com.its.projectjava.domain;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    private static final long serialVersionUid = 1L;

    @Id
    @GeneratedValue
    long id;
    @Version
    long version;
    @Column(unique = true)
    String login;
    String password;

    public User(){
        super();
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public User(String login, String password) {
        super();
        this.login = login;
        this.password = password;
    }
}
