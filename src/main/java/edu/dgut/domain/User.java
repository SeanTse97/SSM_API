package edu.dgut.domain;

public class User {
    String username;
    String password;
    String code;
    String randomStr;
    String codeimg;

    public User() {
        super();
    }

    public User(String username, String password, String code, String randomStr, String codeimg) {
        this.username = username;
        this.password = password;
        this.code = code;
        this.randomStr = randomStr;
        this.codeimg = codeimg;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRandomStr() {
        return randomStr;
    }

    public void setRandomStr(String randomStr) {
        this.randomStr = randomStr;
    }

    public String getCodeimg() {
        return codeimg;
    }

    public void setCodeimg(String codeimg) {
        this.codeimg = codeimg;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", code='" + code + '\'' +
                ", randomStr='" + randomStr + '\'' +
                ", codeimg='" + codeimg + '\'' +
                '}';
    }
}
