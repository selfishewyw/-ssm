package com.demo.dao;

import com.demo.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户Dao类
 *
 * @author Wwwwei
 */
public interface UserDao {
    /**
     * 插入用户记录
     *
     * @param userEntity
     * @return
     */
    Integer insert(UserEntity userEntity);

    /**
     * 删除用户记录
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 更新用户记录
     *
     * @param userEntity
     * @return
     */
    Integer update(UserEntity userEntity);

    /**
     * 根据用户id查找用户
     *
     * @param id
     * @return
     */
    UserEntity selectById(Integer id);

    /**
     * 查询全部
     * @return
     */
    List<UserEntity> selectAll();

    /**
     * 登录
     * @param loginname
     * @param password
     * @return
     */
    UserEntity login(@Param("loginname") String loginname , @Param("password")String password);

    /**
     * 注册
     * @param username
     * @param loginname
     * @param password
     * @param lev
     * @return
     */
    Integer registered( @Param("username")String username , @Param("loginname") String loginname , @Param("password")String password, @Param("lev")String lev);

    /**
     * 分页查询
     * @param user
     * @param start
     * @param pageSize
     * @return
     */
    List<UserEntity> selectuserByLimit(@Param("user")UserEntity user,@Param("start")int start, @Param("pageSize")int pageSize);

    /**
     * 条件查询
     * @param user
     * @return
     */
    List<UserEntity> selectuserByUser(@Param("user")UserEntity user );

}
