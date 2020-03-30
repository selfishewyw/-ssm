package com.demo.dao.entity;

public class CarSpace {
    private String id; //车位id
    private String name;//车位名
    private String status;//车位状态
    private String stopnum;//停车次数
    private String stopsumtime;//总停时长
    private String nowcar;//当前停车号
    private String settlementime;//最后停车时间
    private String createtime;//创建时间
    private String userid;//占用用户

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStopnum() {
        return stopnum;
    }

    public void setStopnum(String stopnum) {
        this.stopnum = stopnum;
    }

    public String getStopsumtime() {
        return stopsumtime;
    }

    public void setStopsumtime(String stopsumtime) {
        this.stopsumtime = stopsumtime;
    }

    public String getNowcar() {
        return nowcar;
    }

    public void setNowcar(String nowcar) {
        this.nowcar = nowcar;
    }

    public String getSettlementime() {
        return settlementime;
    }

    public void setSettlementime(String settlementime) {
        this.settlementime = settlementime;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "CarSpace{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", stopnum='" + stopnum + '\'' +
                ", stopsumtime='" + stopsumtime + '\'' +
                ", nowcar='" + nowcar + '\'' +
                ", settlementime='" + settlementime + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
