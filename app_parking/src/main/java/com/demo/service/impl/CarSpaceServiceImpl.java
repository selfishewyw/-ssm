package com.demo.service.impl;


import com.demo.dao.CarSpaceDao;
import com.demo.dao.entity.CarSpace;
import com.demo.service.CarSpaceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarSpaceServiceImpl implements CarSpaceService {

    @Resource
    private CarSpaceDao carSpaceDao;

    public List selectAll() {
        return carSpaceDao.selectcarspaceall();
    }

    public int addCarSpace(CarSpace carSpace) {
        return carSpaceDao.insert(carSpace);
    }

    public List<CarSpace> selectCarSpaceByLimit(CarSpace carSpace, int currentPage, int pageSize) {
        int start = (currentPage - 1) *pageSize;
        return carSpaceDao.selectCarSpaceByLimit(carSpace,start,pageSize);
    }

    public List<CarSpace> selectparkingByCarSpace(CarSpace carSpace) {
        return carSpaceDao.selectCarSpaceByCarSpace(carSpace);
    }

    public Integer stopcar(CarSpace carSpace) {
        return carSpaceDao.update(carSpace);
    }
}
