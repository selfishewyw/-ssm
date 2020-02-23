package com.demo.dao;


import com.demo.dao.entity.Parkingrecord;
import java.util.List;

/**
 * 停车记录Dao类
 *
 * @author Wwwwei
 */
public interface ParkingrecordDao {

    /**
     * 查询全部
     * @return
     */
    List<Parkingrecord> selectAll();
}
