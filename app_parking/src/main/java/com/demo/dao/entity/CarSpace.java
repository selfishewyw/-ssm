package com.demo.dao.entity;

public class CarSpace {
    private Integer id; //车位id
    private String name;//车位名
    private String status;//车位状态
    private String stopnum;//停车次数
    private String stopsumtime;//总停时长
    private String nowcar;//当前停车号
    private String settlementime;//最后停车时间
    private String createtime;//创建时间

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

    public String getNowCar() {
        return nowcar;
    }

    public void setNowCar(String nowcar) {
        this.nowcar = nowcar;
    }

    public String getSettlementime() {
        return settlementime;
    }

    public void setSettlementime(String settlementime) {
        settlementime = settlementime;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
