package com.demo.controller;

import com.demo.dao.entity.CarSpace;
import com.demo.service.CarSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class CarSpaceController {

    @Autowired
    CarSpaceService carSpaceService;

    @RequestMapping(value = "carspaceall", method = RequestMethod.GET)
    @ResponseBody
    public List carspaceall(){
        List users = carSpaceService.selectAll();
        return  users;
    }

    @RequestMapping(value = "addcarspace", method = RequestMethod.GET)
    @ResponseBody
    public Integer addcarspace(){
        CarSpace carSpace = new CarSpace();
        carSpace.setId(3);
        carSpace.setName("adad");
        Integer integer = carSpaceService.addCarSpace(carSpace);
        return  integer;
    }
}


