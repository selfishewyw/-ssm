package com.demo.dao;


import com.demo.dao.entity.Parkingrecord;
import com.demo.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 分页查询
     * @param parking
     * @param start
     * @param pageSize
     * @return
     */
    List<Parkingrecord> selectparkingByLimit(@Param("parking") Parkingrecord parking, @Param("start")int start, @Param("pageSize")int pageSize);


    /**
     * 条件查询
     * @param parking
     * @return
     */
    List<Parkingrecord> selectparkingByparkging(@Param("parking") Parkingrecord parking );

    /**
     * 增加数据
     * @param parkingrecord
     * @return
     */
    Integer insert (Parkingrecord parkingrecord);
}
