package com.hspedu.qqcommon;

import java.io.Serializable;

/**
 * @author Solider
 * @version 1.0
 * 用户信息
 */
public class User implements Serializable {

    // 添加serialVersionUID属性，提高版本的兼容性
    private static final long serialVersionUID = 1L;
    private String userId; // 用户Id
    private String password; // 用户密码

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public User() {}

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
