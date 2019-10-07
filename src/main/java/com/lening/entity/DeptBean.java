package com.lening.entity;

import java.util.List;

/**
 * 创作时间：2019/8/14 14:18
 * 作者：李增强
 */
public class DeptBean {

    private Integer deptid;
    private String dname;
    private List<UserBean> ubs;
    private List<RoleBean> rbs;

    public List<UserBean> getUbs() {
        return ubs;
    }

    public void setUbs(List<UserBean> ubs) {
        this.ubs = ubs;
    }

    public List<RoleBean> getRbs() {
        return rbs;
    }

    public void setRbs(List<RoleBean> rbs) {
        this.rbs = rbs;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
