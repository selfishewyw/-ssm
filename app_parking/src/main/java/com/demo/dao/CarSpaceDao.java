package com.demo.dao;

import com.demo.dao.entity.CarSpace;
import com.demo.dao.entity.Parkingrecord;
import com.demo.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 分页查询
     * @param carSpace
     * @param start
     * @param pageSize
     * @return
     */
    List<CarSpace> selectCarSpaceByLimit(@Param("carSpace") CarSpace carSpace, @Param("start")int start, @Param("pageSize")int pageSize);


    /**
     * 条件查询
     * @param carSpace
     * @return
     */
    List<CarSpace> selectCarSpaceByCarSpace(@Param("carSpace") CarSpace carSpace );

}
