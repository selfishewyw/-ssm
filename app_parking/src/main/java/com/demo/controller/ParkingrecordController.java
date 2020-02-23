package com.demo.controller;
import com.demo.dao.entity.Parkingrecord;
import com.demo.service.ParkingrecordService;
import com.demo.tool.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ParkingrecordController {

    @Autowired
    ParkingrecordService parkingrecordService;

    @RequestMapping(value = "selectparkingrecordall", method = RequestMethod.GET)
    @ResponseBody
    public List selectparkingrecordall(){
        List parkingrecords = parkingrecordService.selectAll();
        return  parkingrecords;
    }


}
