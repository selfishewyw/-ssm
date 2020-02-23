package com.demo.dao.entity;

/**
 * 用户实体类
 *
 * @author Wwwwei
 */
public class UserEntity {
    private String id; //用户id
    private String username;//用户名
    private String loginname;//用户账号
    private String password;//用户密码
    private String lev;//用户等级
    private String createtime;//创建时间
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLev() {
        return lev;
    }

    public void setLev(String lev) {
        this.lev = lev;
    }
}
