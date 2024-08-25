package com.medrano.marino.demoHprpg2022.Users;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserSignin extends UserLogin{
    private String password_confirm;

    public UserSignin(@JsonProperty("username") String username, @JsonProperty("password") String password,@JsonProperty("password_confirm") String password_confirm) {
        super(username, password);
        this.password_confirm = password_confirm;
    }
    public boolean isPassConfirmed(){
        return (this.getPassword().equals(password_confirm));
    }

    public String getPassword_confirm() {
        return password_confirm;
    }

    public void setPassword_confirm(String password_confirm) {
        this.password_confirm = password_confirm;
    }
}
