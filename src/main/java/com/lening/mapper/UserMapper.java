package com.lening.mapper;

import com.lening.entity.DeptBean;
import com.lening.entity.PowerBean;
import com.lening.entity.RoleBean;
import com.lening.entity.UserBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * 创作时间：2019/8/14 9:07
 * 作者：李增强
 */
public interface UserMapper {
    List<PowerBean> getPowerList();

    List<UserBean> getUserList();

    UserBean getUserById(Integer id);

    void updateUser(UserBean ub);

    List<DeptBean> getDeptList();
    List<RoleBean> getRoleList();

    RoleBean getRoleByRid(Integer rid);

    void deleteRolePowerByRid(Integer rid);

    void insertRolePower(@Param("rid") Integer rid, @Param("id") String id);

    List<PowerBean> getUserPowerById(Integer id);

    List<RoleBean> getRoleListByDeptid(Integer deptid);

    void updateUserRole(@Param("id") Integer id, @Param("rid") Integer rid, @Param("deptid") Integer deptid);

    void updateRoleDept(@Param("rid") Integer rid, @Param("deptid") Integer deptid);

    UserBean getUserByName(String uname);
}
