package com.demo.service.impl;

import com.demo.dao.UserDao;
import com.demo.dao.entity.UserEntity;
import com.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户服务实现类
 *
 * @author Wwwwei
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 注册
     * @param userEntity
     * @return
     */
    public Integer createUser(UserEntity userEntity) {
        return userDao.insert(userEntity);
    }

    /**
     * 修改
     * @param userEntity
     * @return
     */
    public Integer updateUser(UserEntity userEntity) {
        return userDao.update(userEntity);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public Integer deleteUser(Integer id) {
        return userDao.delete(id);
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    public UserEntity getUserById(Integer id) {
        return userDao.selectById(id);
    }

    /**
     * 查询全部数据
     * @return
     */
    public List selectAll() {
        return userDao.selectAll();
    }

    /**
     * 登录
     * @param loginname
     * @param password
     * @return
     */
    public UserEntity login(String loginname ,String password) {
        return userDao.login(loginname,password);
    }

    /**
     * 分页查询
     * @param userEntity
     * @param currentPage
     * @param pageSize
     * @return
     */
    public List<UserEntity> selectuserByLimit(UserEntity userEntity, int currentPage, int pageSize) {
        int start = (currentPage - 1) *pageSize;
        return userDao.selectuserByLimit(userEntity,start,pageSize);
    }

    /**
     * 条件查询
     * @param user
     * @return
     */
    public List<UserEntity> selectuserByUser(UserEntity user) {
        return userDao.selectuserByUser(user);
    }
}
