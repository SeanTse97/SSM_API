package edu.dgut.controller;

import edu.dgut.domain.Result;
import edu.dgut.domain.User;
import edu.dgut.domain.User2;
import edu.dgut.service.UserService;
import edu.dgut.util.CompareInfoUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/register")
    @ResponseBody
    public HashMap register(User userInfo){
        //初始化数据对象
        String userMobile = userInfo.getUsername();
        String pwd = userInfo.getPassword();
        long addTime = new Date().getTime();
        long editTime = addTime;
        String userId =  UUID.randomUUID().toString().replaceAll("-","");

        User2 u = new User2();
        u.setAddTime(addTime);
        u.setEditTime(editTime);
        u.setUserId(userId);
        u.setUserMobile(userMobile);
        u.setUserPassword(pwd);

        //存入数据库
        int i = userService.saveUserInfo(u);
        HashMap map = new HashMap();
        if(i==1) {
            map.put("success", Boolean.TRUE);
            return map;
        }else{
            map.put("success", Boolean.FALSE);
        }
        return map;
    }


    @PostMapping("/login")
    @ResponseBody
    public HashMap login(User userInfo, HttpServletResponse response){
        String useMobile = userInfo.getUsername();
        String pwd = userInfo.getPassword();
        User2 u = userService.getSingleUser(useMobile);
        HashMap map = new HashMap();
        if(u == null){
            map.put("success",Boolean.FALSE);
            map.put("msg","账号错误！");
            return map;
        }if(!u.getUserPassword().equals(pwd)){
            map.put("success",Boolean.FALSE);
            map.put("msg","密码错误！");
            return map;
        }if(u.getIsLock().equals("Y")){
            map.put("success",Boolean.FALSE);
            map.put("msg","账号被锁定！");
            return map;
        }if(u.getRoleId()== 2){
            map.put("success",Boolean.FALSE);
            map.put("msg","账号权限不足！");
            return map;
        }
        //设置cookies信息
        Cookie cookie = new Cookie("name", u.getUserName());
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);
        map.put("success",Boolean.TRUE);
        map.put("turn",u.getRoleId());
        return map;
    }

    //获取用户列表
    @PostMapping("/list")
    @ResponseBody
    public Result getAllUser(@RequestParam("page") String page,@RequestParam("limit") String limit,
                             @RequestParam(value = "userName",required = false)String userName,@RequestParam(value = "userMobile",required = false) String userMobile,@RequestParam(value = "isLock",required = false) String isLock){
        List<User2> list = new LinkedList<>();
        int limt = Integer.parseInt(limit);
        int start = (Integer.parseInt(page)-1) * limt;
        list = userService.getUserByCondition(start,limt,userName,userMobile,isLock);
        int count = userService.getUserCount(userName,userMobile,isLock);
        return Result.success(list,count);

    }
    //获取单个用户信息
    @PostMapping("info")
    @ResponseBody
    public Result getUserInfo(@CookieValue("user") String userMobile){
        User2 u = userService.getSingleUser(userMobile);
        return Result.success(u,1);
    }
    //删除用户信息
    @DeleteMapping("delete")
    @ResponseBody
    public HashMap deleteUser(@RequestParam("ids") String ids){
        int  i = userService.deleteUser(ids);
        HashMap map = new HashMap();
        if(i == 1){
            map.put("success",Boolean.TRUE);
        }else{
            map.put("success",Boolean.FALSE);
        }

        return map;
    }


    //保存和编辑
    @PostMapping("save")
    @ResponseBody
    public HashMap saveUser(User2 user, @CookieValue(value = "user") String userMobile, @CookieValue(value = "name")String name) throws CloneNotSupportedException {

        HashMap map = new HashMap();
        //判断新增的对象还是保存的对象
        if(user.getUserId().length() != 0){
            //执行编辑操作
            User2 u = userService.getSingleUser2(user.getUserId());
            //获取修改后的对象
            CompareInfoUtil<User2> comp = new CompareInfoUtil<>(u,user);
            User2 nu = comp.compare1to2();

            nu.setEditTime(new Date().getTime());
            nu.setEditUser(name);
            int i = userService.updateUserInfo(nu);
            if( i == 1){
                map.put("success",Boolean.TRUE);
            }else{
                map.put("success",Boolean.FALSE);
                map.put("msg","服务端出错了！请稍候重试！！");
            }
        }else{
            //执行保存操作
            long addTime = new Date().getTime();
            long editTime = addTime;
            String userId = UUID.randomUUID().toString().replaceAll("-","");
            user.setAddTime(addTime);
            user.setEditTime(editTime);
            user.setUserId(userId);
            user.setAddUser(name);
            user.setUserPassword("123456");
            int i = userService.saveUserInfo(user);
            if( i == 1){
                map.put("success",Boolean.TRUE);
            }else{
                map.put("success",Boolean.FALSE);
                map.put("msg","服务端出错了！请稍候重试！！");
            }
        }

        return map;
    }


    //重置密码
    @PostMapping("pwd")
    @ResponseBody
    public HashMap resetPass(@RequestParam("userId") String id){
        userService.resetPwd(id);
        HashMap map = new HashMap();
        map.put("success",Boolean.TRUE);
        return map;
    }



    //修改状态
    @GetMapping("/lock")
    @ResponseBody
    public HashMap modifyLock(@RequestParam("userId") String userId, @RequestParam("lock") String lock){
        //'Y'是锁定
        userService.modifyLock(userId,lock);
        HashMap map = new HashMap();
        map.put("success",Boolean.TRUE);
        return map;
    }
}
