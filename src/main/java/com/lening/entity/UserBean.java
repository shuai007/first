package com.lening.entity;

import java.util.Date;

/**
 * 创作时间：2019/8/14 9:41
 * 作者：李增强
 */
public class UserBean {

    private Integer id;
    private String uname;
    private String pwd;

    /**
     * 从前台传递过来的时间需要转化
     */
   //@DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date birthday;
    private String address;

    private DeptBean db;
    private RoleBean rb;

    public DeptBean getDb() {
        return db;
    }

    public void setDb(DeptBean db) {
        this.db = db;
    }

    public RoleBean getRb() {
        return rb;
    }

    public void setRb(RoleBean rb) {
        this.rb = rb;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
