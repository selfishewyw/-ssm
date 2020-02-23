package com.demo.service.impl;

import com.demo.dao.ParkingrecordDao;
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
}
