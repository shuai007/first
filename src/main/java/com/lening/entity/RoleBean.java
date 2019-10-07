package com.lening.entity;

import java.util.List;

/**
 * 创作时间：2019/8/14 14:19
 * 作者：李增强
 */
public class RoleBean {

    private Integer rid;
    private String rname;

    private DeptBean db;
    private List<PowerBean> pbs;

    public List<PowerBean> getPbs() {
        return pbs;
    }

    public void setPbs(List<PowerBean> pbs) {
        this.pbs = pbs;
    }

    public DeptBean getDb() {
        return db;
    }

    public void setDb(DeptBean db) {
        this.db = db;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }
}
