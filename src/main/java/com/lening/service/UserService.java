package com.lening.service;

import com.lening.entity.DeptBean;
import com.lening.entity.PowerBean;
import com.lening.entity.RoleBean;
import com.lening.entity.UserBean;
import com.lening.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.swing.text.rtf.RTFEditorKit;
import java.util.*;

/**
 * 创作时间：2019/8/14 9:06
 * 作者：李增强
 */
@Service
public class UserService {
    @Resource
    UserMapper userMapper;

    public List<PowerBean> getPowerList() {
        return userMapper.getPowerList();
    }
    public List<PowerBean> getPowerList(Integer rid) {
        List<PowerBean> list = userMapper.getPowerList();
        RoleBean rb = userMapper.getRoleByRid(rid);
        if(rb.getPbs()!=null){
            for(PowerBean p:rb.getPbs()){
                for (PowerBean pb : list) {
                    if(p.getId().equals(pb.getId())){
                        pb.setChecked(true);
                        break;
                    }
                }
            }
        }
        return list;
    }

    public List<UserBean> getUserList() {
        return userMapper.getUserList();
    }

    public UserBean getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    public void updateUser(UserBean ub) {
        userMapper.updateUser(ub);
    }

    public List<DeptBean> getDeptList() {
        return userMapper.getDeptList();
    }

    public List<RoleBean> getRoleList() {
        return userMapper.getRoleList();
    }


    public void updateRolePower(Integer rid, String ids) {
        userMapper.deleteRolePowerByRid(rid);
        if(ids!=null&&ids.length()>=1){
            for (String id : ids.split(",")) {
                userMapper.insertRolePower(rid,id);
            }
        }
    }

    public List<PowerBean> getUserPowerById(Integer id) {
        return userMapper.getUserPowerById(id);
    }

    public List<RoleBean> getRoleListByDeptid(UserBean ub) {
        if(ub.getDb()!=null){
            return userMapper.getRoleListByDeptid(ub.getDb().getDeptid());
        }
        return null;
    }

    public void updateUserRole(Integer id, Integer rid, Integer deptid) {
        userMapper.updateUserRole(id,rid,deptid);
    }

    public RoleBean getRoleByRid(Integer rid) {
        return userMapper.getRoleByRid(rid);
    }

    public void updateRoleDept(Integer rid, Integer deptid) {
        userMapper.updateRoleDept(rid,deptid);
    }

    public UserBean getUserByName(UserBean ub) {
        if(ub!=null){
           UserBean rub =  userMapper.getUserByName(ub.getUname());
           if(rub!=null){
               if(rub.getPwd().equals(ub.getPwd())){
                   return rub;
               }
           }
        }
        return null;
    }

    public Map getPowerListById(UserBean ub) {
        if(ub!=null){
            List<PowerBean> ulist = userMapper.getUserPowerById(ub.getId());
            Map map = new HashMap();
            Set urls = new HashSet();
            List<PowerBean> blist = new ArrayList<PowerBean>();
            int y = ulist.size();
            for (int i = 0; i < y; i++) {

                /**
                 * 是把所有的url放进set里面
                 */
                urls.add(ulist.get(i).getUrl());

                /**
                 * 数据库buttonflag字段没有值的时候，默认是null，aa等于null
                 * null和1比较，基本数据类型的包装类，先拆箱，发生异常
                 */
                Integer aa = ulist.get(i).getButtonflag();
                if(aa==1){
                    blist.add(ulist.get(i));
                    ulist.remove(i);
                    i--;y--;
                }
            }
            map.put("blist", blist);
            map.put("urls", urls);
            map.put("ulist", ulist);
            return map;
        }
        return null;
    }

    public List<RoleBean> getRoleListByDeptid(Integer deptid) {
        return userMapper.getRoleListByDeptid(deptid);
    }
}
