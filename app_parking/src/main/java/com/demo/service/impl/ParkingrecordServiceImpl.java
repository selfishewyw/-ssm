package com.demo.service.impl;

import com.demo.dao.ParkingrecordDao;
import com.demo.dao.entity.Parkingrecord;
import com.demo.service.ParkingrecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ParkingrecordServiceImpl implements ParkingrecordService {

    @Resource
    private ParkingrecordDao parkingrecordDao;

    public List selectAll() {
        return parkingrecordDao.selectAll();
    }

    public List<Parkingrecord> selectparkingByLimit(Parkingrecord parking, int currentPage, int pageSize) {
        int start = (currentPage - 1) *pageSize;

        return parkingrecordDao.selectparkingByLimit(parking,start,pageSize);
    }
}
