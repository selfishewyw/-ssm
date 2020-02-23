package com.demo.dao;

import com.demo.dao.entity.CarSpace;
import com.demo.dao.entity.UserEntity;

import java.util.List;

/**
 * 车位Dao类
 *
 * @author Wwwwei
 */
public interface CarSpaceDao {
    /**
     * 插入用户记录
     *
     * @param carSpace
     * @return
     */
    Integer insert(CarSpace carSpace);

//    /**
//     * 删除用户记录
//     *
//     * @param id
//     * @return
//     */
//    Integer delete(Integer id);

    /**
     * 更新用户记录
     *
     * @param carSpace
     * @return
     */
    Integer update(CarSpace carSpace);

//    /**
//     * 根据用户id查找用户
//     *
//     * @param id
//     * @return
//     */
//    UserEntity selectById(Integer id);

    /**
     * 查询所有
     * @return
     */
    List<CarSpace> selectcarspaceall();

}
