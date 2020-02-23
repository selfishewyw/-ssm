package com.demo.controller;

import com.demo.dao.entity.UserEntity;
import com.demo.service.UserService;
import com.demo.tool.Json;
import com.demo.tool.PageSize;
import com.demo.tool.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by wwwwei on 17/3/18.
 */
@Controller
public class UserController {

    @Autowired
    UserService user_service;

    @RequestMapping(value = "select", method = RequestMethod.GET)
    @ResponseBody
    public UserEntity select(){
        UserEntity user = user_service.getUserById(1);
        user.setId("1");
        List list = new ArrayList();
        list.add(user);
        return  user;
    }

    /**
     * 查询全部用户
     * @return
     */
    @RequestMapping(value = "selectall", method = RequestMethod.GET)
    @ResponseBody
    public List testService(){
        List users = user_service.selectAll();
        return  users;
    }

    /**
     * 登录
     * @param loginname
     * @param password
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    @ResponseBody
    public UserEntity login(@RequestParam("loginname") String loginname,@RequestParam("password") String password){
        UserEntity users = user_service.login(loginname,password);
        return  users;
    }

    @RequestMapping(value = "registered", method = RequestMethod.GET)
    @ResponseBody
    public Json registered(@RequestParam("username") String username, @RequestParam("loginname") String loginname, @RequestParam("password") String password){
        Json json = new Json();

        UserEntity user = new UserEntity();
        user.setId(Tool.getuuid());
        user.setLoginname(loginname);
        user.setUsername(username);
        user.setPassword(password);
        user.setLev("0");
        user.setCreatetime(Tool.getTime());
        try{
            int count = user_service.createUser(user);
            if (count>0){
                List<UserEntity> users = new ArrayList<UserEntity>();
                users.add(user);
                json.setHttpstatus(200);
                json.setIsSuccess(true);
                json.setMessage("注册成功");
                json.setRowList(users);
            }
        }catch (Exception e){
            json.setHttpstatus(500);
            json.setIsSuccess(false);
            json.setMessage("注册失败");
            json.setRowList(null);
        }
        return  json;
    }

    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @param username
     * @param loginname
     * @param lev
     * @return
     */
    @RequestMapping(value = "selectuserByLimit", method = RequestMethod.GET)
    @ResponseBody
    public Json selectuserByLimit(@RequestParam("currentPage") String currentPage,@RequestParam("pageSize") String pageSize,@RequestParam("username") String username, @RequestParam("loginname") String loginname, @RequestParam("lev") String lev){
        Json json = new Json();
        UserEntity user = new UserEntity();
        user.setLev(lev);
        user.setUsername(username);
        user.setLoginname(loginname);
        try{
            List userEntities =  user_service.selectuserByLimit(user,Integer.parseInt(currentPage),Integer.parseInt(pageSize));
            int counts = user_service.selectuserByUser(user).size();
            PageSize count = new PageSize();
            json.setCount(counts);
            if (userEntities.size()>0){
                json.setHttpstatus(200);
                json.setIsSuccess(true);
                json.setMessage("查询成功");
                json.setRowList(userEntities);
            }
        }catch (Exception e){
            json.setHttpstatus(500);
            json.setIsSuccess(false);
            json.setMessage("查询失败");
            json.setRowList(null);
        }
        return  json;
    }

    @RequestMapping(value = "updateUser", method = RequestMethod.GET)
    @ResponseBody
    public Json updateUser(@RequestParam("id") String id,@RequestParam("password") String password,@RequestParam("username") String username, @RequestParam("loginname") String loginname, @RequestParam("lev") String lev){
        Json json = new Json();
        UserEntity user = new UserEntity();
        user.setLev(lev);
        user.setUsername(username);
        user.setLoginname(loginname);
        user.setId(id);
        user.setPassword(password);
        try{
           int count =  user_service.updateUser(user);
            if (count>0){
                json.setHttpstatus(200);
                json.setIsSuccess(true);
                json.setMessage("修改成功");
                json.setRowList(null);
            }
        }catch (Exception e){
            json.setHttpstatus(500);
            json.setIsSuccess(false);
            json.setMessage(e.getMessage());
            json.setRowList(null);
        }
        return  json;
    }
}
