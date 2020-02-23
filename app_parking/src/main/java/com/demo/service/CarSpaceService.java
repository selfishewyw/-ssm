package com.demo.service;

import com.demo.dao.entity.CarSpace;

import java.util.List;

public interface CarSpaceService {
    List selectAll();

    int addCarSpace(CarSpace carSpace);
}
