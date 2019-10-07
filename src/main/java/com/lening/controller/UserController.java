package com.lening.controller;

import com.lening.entity.DeptBean;
import com.lening.entity.PowerBean;
import com.lening.entity.RoleBean;
import com.lening.entity.UserBean;
import com.lening.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.management.relation.RoleList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 创作时间：2019/8/14 9:06
 * 作者：李增强
 */
@Controller
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("/getLogin")
    public ModelAndView getLogin(UserBean ub, HttpServletRequest request,HttpServletResponse response){
        ModelAndView mv = null;
        UserBean rub = userService.getUserByName(ub);
        if(rub!=null){
            request.getSession().setAttribute("ub", rub);
            mv = new ModelAndView("main");
        }else{
            try {
                request.setAttribute("msg", "登录失败");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  mv;

    }

    /**
     * 保存给角色选择部门
     * springMVC中，要是方法的没有返回值，他会默认  把访问路径当成页面名称了
     * 解决方案：@ResponseBody
     */
    @RequestMapping("/updateRoleDept")
    @ResponseBody
    public void updateRoleDept(Integer rid,Integer deptid){
        userService.updateRoleDept(rid,deptid);
    }
    /**
     * 去给角色选择部门
     */
    @RequestMapping("/toRoleDept")
    public ModelAndView toRoleDept(Integer rid){
        ModelAndView mv = new ModelAndView("role_dept");
        RoleBean rb = userService.getRoleByRid(rid);
        List<DeptBean> list = userService.getDeptList();
        mv.addObject("rb", rb);
        mv.addObject("list", list);
        return mv;
    }

    @RequestMapping("/updateUserRole")
    public void updateUserRole(Integer id, Integer rid, Integer deptid){
        userService.updateUserRole(id,rid,deptid);
    }
    /**
     * 通过部门id查询部门角色的方法ajax的
     */
    @RequestMapping("/getRoleListByDeptid")
    public void getRoleListByDeptid(HttpServletResponse response,Integer deptid){
        List<RoleBean> list = userService.getRoleListByDeptid(deptid);
        String json = JSONArray.fromObject(list).toString();
        try {
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 去给用户选择角色页面
     */
    @RequestMapping("/toUserRole")
    public ModelAndView toUserRole(Integer id){
        ModelAndView mv = new ModelAndView("user_role");
        UserBean ub = userService.getUserById(id);
        mv.addObject("ub", ub);

        List<DeptBean> list = userService.getDeptList();
        /**
         * ub.getDb()有可能为空，所以这行代码有可能报空指针异常，解决方案
         * 1、把ub给方案，在service判断（最佳）
         * 2、在userBean中直接new一下db（不建议）
         */
        List<RoleBean> rlist = userService.getRoleListByDeptid(ub);
        mv.addObject("rlist", rlist);
        mv.addObject("list", list);
        return mv;
    }

    /**
     * 查看用户的权限
     */
    @RequestMapping("/getUserPowerById")
    public ModelAndView getUserPowerById(Integer id){
        ModelAndView mv = new ModelAndView("user_power");
        List<PowerBean> list = userService.getUserPowerById(id);
        String json = JSONArray.fromObject(list).toString();
        mv.addObject("json", json);
        return mv;
    }
    /**
     * 保存给角色分配的权限
     *
     */
    @RequestMapping("/updateRolePower")
    public  String updateRolePower(Integer rid,String ids){
        userService.updateRolePower(rid,ids);
        return "redirect:getRoleList.do";
    }

    /**
     * 去给角色分配权限页面
     * @return
     */
    @RequestMapping("/toRolePower")
    public ModelAndView toRolePower(Integer rid){
        ModelAndView mv = new ModelAndView("role_power");
        List<PowerBean> list = userService.getPowerList(rid);
       /* JsonConfig jc = new JsonConfig();
        jc.setExcludes(new String[]{"url"});
        String json = JSONArray.fromObject(list, jc).toString();*/
       String json = JSONArray.fromObject(list).toString();
        mv.addObject("json", json);
        mv.addObject("rid", rid);
        return mv;
    }


    @RequestMapping("/getRoleList")
    public ModelAndView getRoleList(){
        ModelAndView mv = new ModelAndView("role_list");
        List<RoleBean> list = userService.getRoleList();
        mv.addObject("list", list);
        return mv;
    }
    @RequestMapping("/getDeptList")
    public ModelAndView getDeptList(){
        ModelAndView mv = new ModelAndView("dept_list");
        List<DeptBean> list = userService.getDeptList();
        mv.addObject("list", list);
        return mv;
    }

    /**
     * 日期的处理，这是在controller层处理的，也可以直接在entity上加一个注解
     * @DateTimeFormat(pattern = "yyyy-MM-dd")
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/updateUser")
    public String updateUser(UserBean ub){
        userService.updateUser(ub);
        return "redirect:getUserList.do";
    }

    /**
     * 去修改页面
     * @return
     */
    @RequestMapping("/toUpdateUser")
    public ModelAndView toUpdateUser(Integer id){
        ModelAndView mv = new ModelAndView("user_update");
        UserBean ub = userService.getUserById(id);
        mv.addObject("ub", ub);
        return mv;
    }


    @RequestMapping("/getPowerJson")
    public ModelAndView getPowerJson(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("left");
        HttpSession session = request.getSession();
        UserBean ub = (UserBean)session.getAttribute("ub");
        /**
         * 到这个地方后，list里面已经没有button了，不符合
         * 不但要把含有button的url放进session，还要专门把button的按钮信息，
         * 放进sesion，页面做按钮的时候使用（第三步，按钮级别权限的时候使用）
         * 一次性处理完毕，
         * 拿到：1、没有button的list，给菜单  list
         *       2、所有的url，包括button的url给sesion  set
         *       3、所有button的powerBean的信息（页面使用）list
         *       一个方法，返回3个值，怎么处理，map
         */
        Map map = userService.getPowerListById(ub);
        Set<String> urls = (Set<String>)map.get("urls");
        List<PowerBean> blist = (List<PowerBean>)map.get("blist");
        session.setAttribute("urls", urls);
        session.setAttribute("blist", blist);
        String json = JSONArray.fromObject(map.get("ulist")).toString();
        mv.addObject("json", json);
        return mv;
    }

    @RequestMapping("/getUserList")
    public ModelAndView getUserList(){
        ModelAndView mv = new ModelAndView("user_list");
        List<UserBean> list = userService.getUserList();
        mv.addObject("list", list);
        return  mv;
    }
}
