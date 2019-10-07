package com.lening.entity;

/**
 * 创作时间：2019/8/8 14:29
 * 作者：李增强
 */
public class PowerBean {

    private Integer id;
    private Integer pid;
    private String pname;
    private String url;
    private String icon;
    private String target;
    private Integer buttonflag;

    public Integer getButtonflag() {
        return buttonflag;
    }

    public void setButtonflag(Integer buttonflag) {
        this.buttonflag = buttonflag;
    }

    private boolean checked=false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
