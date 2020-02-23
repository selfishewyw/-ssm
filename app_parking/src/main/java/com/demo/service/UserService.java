package com.demo.service;

import com.demo.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户服务类
 *
 * @author Wwwwei
 */
public interface UserService {

    /**
     * 注册用户
     * @param userEntity
     * @return
     */
    Integer createUser(UserEntity userEntity);

    /**
     * 修改用户数据
     * @param userEntity
     * @return
     */
    Integer updateUser(UserEntity userEntity);

    /**
     * 产出用户
     * @param id
     * @return
     */
    Integer deleteUser(Integer id);

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    UserEntity getUserById(Integer id);

    /**
     * 查询全部用户
     * @return
     */
    List selectAll();

    /**
     * 登录
     * @param loginname
     * @param password
     * @return
     */
    UserEntity login(String loginname ,String password);

    /**
     * 分页查询
     * @param userEntity
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<UserEntity> selectuserByLimit(UserEntity userEntity,int currentPage,int pageSize);

    /**
     * 条件查询
     * @param user
     * @return
     */
    List<UserEntity> selectuserByUser(UserEntity user );
}
