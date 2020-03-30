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


    @RequestMapping(value = "selectparkingByLimit", method = RequestMethod.GET)
    @ResponseBody
    public Json selectparkingByLimit(@RequestParam("currentPage") String currentPage,
                                     @RequestParam("pageSize") String pageSize,
                                     @RequestParam("userid") String userid,
                                     @RequestParam("carspacename") String carspacename,
                                     @RequestParam("carnumber") String carnumber,
                                     @RequestParam("parkingfee") String parkingfee){

        Json json = new Json();
        Parkingrecord parkingrecord = new Parkingrecord();
        parkingrecord.setParkingfee(parkingfee);
        parkingrecord.setCarnumber(carnumber);
        parkingrecord.setCarspacename(carspacename);
        parkingrecord.setCreateman(userid);
        try {
            List carSpaces = parkingrecordService.selectparkingByLimit(parkingrecord,Integer.parseInt(currentPage),Integer.parseInt(pageSize));
            json.setRowList(carSpaces);
            json.setIsSuccess(true);
            json.setHttpstatus(200);
            json.setCount(parkingrecordService.selectparkingByparkging(parkingrecord).size());
            json.setMessage("查询成功");
        }catch (Exception e){
            json.setMessage(e.getMessage());
        }
        return  json;
    }

}
