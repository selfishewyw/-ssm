package com.demo.tool;

import java.util.List;

/**
 * 返回前台类
 */
public class Json {
    // 操作是否成功
    private boolean isSuccess;

    // 操作结果信息
    private String message;

    //请求状态
    private int httpstatus;

    // 操作正确之后的 返回数据
    private List rowList;

    //count 查询条数
    private int count;


    public Json() {
        super();
    }

    public Json(boolean isSuccess, String message, List rowList) {
        super();
        this.isSuccess = isSuccess;
        this.message = message;
        this.rowList = rowList;
    }



    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isSuccess() {
        return isSuccess;
    }


    public int getHttpstatus() {
        return httpstatus;
    }

    public void setHttpstatus(int httpstatus) {
        this.httpstatus = httpstatus;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List getRowList() {
        return rowList;
    }

    public void setRowList(List rowList) {
        this.rowList = rowList;
    }
}