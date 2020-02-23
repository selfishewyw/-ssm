package com.demo.tool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Tool {


    /**
     * 获取uuid
     * @return
     */
    public static String  getuuid(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 获取当前时间
     * @return
     */
    public static String getTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return  df.format(new Date());
    }

}
