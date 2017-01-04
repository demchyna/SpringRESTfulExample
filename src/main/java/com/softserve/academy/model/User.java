package com.softserve.academy.model;
import java.util.Date;

public class User {

    private Integer id = count++;
    private String login;
    private String password;
    private Date createDate = new Date();

    private static int count = 0;

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        if (id != null) {
            this.id = id;
        }
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate() {
        this.createDate = new Date();
    }
}
