package com.demo.dao.entity;

public class Parkingrecord {

    private String id; //停车记录id
    private String carspaceid;//外键车位表
    private String carspacename;//外键车位名
    private String carnumber;//车牌号
    private String endtime;//离开时间
    private String duration;//停车时长
    private String parkingfee;//停车费
    private String createman;//创建人

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarspaceid() {
        return carspaceid;
    }

    public void setCarspaceid(String carspaceid) {
        this.carspaceid = carspaceid;
    }

    public String getCarspacename() {
        return carspacename;
    }

    public void setCarspacename(String carspacename) {
        this.carspacename = carspacename;
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getParkingfee() {
        return parkingfee;
    }

    public void setParkingfee(String parkingfee) {
        this.parkingfee = parkingfee;
    }

    public String getCreateman() {
        return createman;
    }

    public void setCreateman(String createman) {
        this.createman = createman;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    private String createtime;//创建时间
}
