package com.demo.service;

import com.demo.dao.entity.CarSpace;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarSpaceService {
    List selectAll();

    int addCarSpace(CarSpace carSpace);

    /**
     * 分页查询
     * @param carSpace
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<CarSpace> selectCarSpaceByLimit(CarSpace carSpace, int currentPage, int pageSize);


    /**
     * 条件查询
     * @param carSpace
     * @return
     */
    List<CarSpace> selectparkingByCarSpace(CarSpace carSpace );

    /**
     *
     * @param carSpace
     * @return
     */
    Integer stopcar(CarSpace carSpace);
}
