package com.demo.controller;

import com.demo.dao.entity.CarSpace;
import com.demo.dao.entity.Parkingrecord;
import com.demo.service.CarSpaceService;
import com.demo.service.ParkingrecordService;
import com.demo.tool.Json;
import com.demo.tool.Tool;
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


    @Autowired
    ParkingrecordService parkingrecordService;

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
    public Json selectcarSpaceByLimit(@RequestParam("currentPage") String currentPage, @RequestParam("pageSize") String pageSize, @RequestParam("name") String name, @RequestParam("nowcar") String nowcar, @RequestParam("status") String status){
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
    public Json stopcar(@RequestParam("id") String id,
                        @RequestParam("nowcar") String nowcar,
                        @RequestParam("userid") String userid,
                        @RequestParam("stopnum") String stopnum){
        Json json = new Json();
        CarSpace carSpace = new CarSpace();
        carSpace.setId(id);
        carSpace.setStatus("1");
        carSpace.setNowcar(nowcar);
        carSpace.setUserid(userid);
        carSpace.setStopnum((Integer.parseInt(stopnum)+1) +"");
        carSpace.setSettlementime(Tool.getTime());

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

    @RequestMapping(value = "settlement", method = RequestMethod.GET)
    @ResponseBody
    public Json settlement(@RequestParam("id") String id,
                           @RequestParam("sumtime") String sumtime,
                           @RequestParam("stopsumtime") String stopsumtime,
                           @RequestParam("name") String name,
                           @RequestParam("status") String status,
                           @RequestParam("nowcar") String nowcar,
                           @RequestParam("settlementime") String settlementime,
                           @RequestParam("userid") String userid,
                           @RequestParam("sumprice") String sumprice
                           ){
        Json json = new Json();
        CarSpace carSpace = new CarSpace();
        carSpace.setId(id);
        carSpace.setStatus("0");
        carSpace.setStopsumtime(Float.parseFloat(sumtime)+Float.parseFloat(stopsumtime)+"");
        carSpace.setNowcar("");
        Parkingrecord parkingrecord = new Parkingrecord();
        parkingrecord.setId(Tool.getuuid());
        parkingrecord.setCarnumber(nowcar);
        parkingrecord.setCarspaceid(id);
        parkingrecord.setCarspacename(name);
        parkingrecord.setDuration(sumtime);
        parkingrecord.setCreatetime(settlementime);
        parkingrecord.setParkingfee(sumprice);
        parkingrecord.setCreateman(userid);
        try {
            int count = carSpaceService.settlement(carSpace);
            int count1 = parkingrecordService.insert(parkingrecord);
            if (count>0 && count1>0){
                json.setIsSuccess(true);
                json.setHttpstatus(200);
            }
        }catch (Exception e){
            json.setMessage(e.getMessage());
        }
        return  json;
    }
    @RequestMapping(value = "parkingedit", method = RequestMethod.GET)
    @ResponseBody
    public Json parkingedit(@RequestParam("id") String id ,@RequestParam("settlementime") String settlementime,@RequestParam("stopsumtime") String stopsumtime, @RequestParam("stopnum") String stopnum, @RequestParam("name") String name){
        Json json = new Json();
        CarSpace carSpace = new CarSpace();
        carSpace.setId(id);


        carSpace.setStopnum(stopnum);
        carSpace.setSettlementime(settlementime);
        carSpace.setStopsumtime(stopsumtime);
        carSpace.setName(name);
        try {
            int count = carSpaceService.parkingedit(carSpace);

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