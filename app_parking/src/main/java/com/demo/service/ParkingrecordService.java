package com.demo.service;

import com.demo.dao.entity.Parkingrecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParkingrecordService {
    List selectAll();

    /**
     * 分页查询
     * @param parking
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<Parkingrecord> selectparkingByLimit(Parkingrecord parking, int currentPage, int pageSize);


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
