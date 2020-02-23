package com.demo.controller;

import com.demo.dao.entity.CarSpace;
import com.demo.dao.entity.Parkingrecord;
import com.demo.service.CarSpaceService;
import com.demo.tool.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sound.midi.Soundbank;
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
        carSpace.setId("3");
        carSpace.setName("adad");
        Integer integer = carSpaceService.addCarSpace(carSpace);
        return  integer;
    }

    @RequestMapping(value = "selectcarSpaceByLimit", method = RequestMethod.GET)
    @ResponseBody
    public Json selectparkingByLimit(@RequestParam("currentPage") String currentPage, @RequestParam("pageSize") String pageSize, @RequestParam("name") String name, @RequestParam("nowcar") String nowcar, @RequestParam("status") String status){
        Json json = new Json();
        CarSpace carSpace = new CarSpace();
        carSpace.setName(name);
        carSpace.setStatus(status);
        carSpace.setNowcar(nowcar);
        try {
            List carSpaces = carSpaceService.selectCarSpaceByLimit(carSpace,Integer.parseInt(currentPage),Integer.parseInt(pageSize));
            json.setRowList(carSpaces);
            json.setIsSuccess(true);
            json.setHttpstatus(200);
            json.setCount(carSpaceService.selectparkingByCarSpace(carSpace).size());
            json.setMessage("查询成功");
        }catch (Exception e){
            json.setMessage(e.getMessage());
        }
        return  json;
    }

    @RequestMapping(value = "stopcar", method = RequestMethod.GET)
    @ResponseBody
    public Json stopcar(@RequestParam("id") String id, @RequestParam("nowcar") String nowcar, @RequestParam("stopnum") String stopnum){
        Json json = new Json();
        CarSpace carSpace = new CarSpace();
        carSpace.setId(id);
        carSpace.setStatus("1");
        carSpace.setNowcar(nowcar);
        carSpace.setStopnum((Integer.parseInt(stopnum)+1) +"");
        try {
            int count = carSpaceService.stopcar(carSpace);
            if (count>0){
                json.setIsSuccess(true);
                json.setHttpstatus(200);
            }
        }catch (Exception e){
            json.setMessage(e.getMessage());
        }
        return  json;
    }
}


