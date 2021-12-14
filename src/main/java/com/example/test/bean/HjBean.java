package com.example.test.bean;

public class HjBean {
    private String id;
    private String hj;
    private String sfz;
    private String yy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHj() {
        return hj;
    }

    public void setHj(String hj) {
        this.hj = hj;
    }

    public String getSfz() {
        return sfz;
    }

    public void setSfz(String sfz) {
        this.sfz = sfz;
    }

    public String getYy() {
        return yy;
    }

    public void setYy(String yy) {
        this.yy = yy;
    }

    @Override
    public String toString() {
        return "HjBean{" +
                "id='" + id + '\'' +
                ", hj='" + hj + '\'' +
                ", sfz='" + sfz + '\'' +
                ", yy='" + yy + '\'' +
                '}';
    }
}
