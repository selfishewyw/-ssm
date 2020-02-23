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
}
