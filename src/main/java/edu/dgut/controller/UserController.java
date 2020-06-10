package edu.dgut.controller;

import edu.dgut.domain.Result;
import edu.dgut.domain.User2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("api/user")
public class UserController {

    //获取用户列表
    @PostMapping("/list")
    @ResponseBody
    public Result getAllUser(@RequestParam("page") String page,@RequestParam("limit") String limit,
                             @RequestParam(value = "userName",required = false)String userName,@RequestParam(value = "userMobile",required = false) String userMobile,@RequestParam(value = "isLock",required = false) String isLock){
        System.out.println(page+"-"+limit+"-"+userName+"-"+userMobile+"-"+isLock);
        List<User2> list = new LinkedList<>();
        User2 u = new User2("null", "谢晓鑫",1513478681000l,1513478681000l , "1001", "谢晓鑫", "123123", "11111111111", "广东省", "广州市", "市辖区", "太撒旦", "N", 2);
        User2 u2 = new User2("null", "谢晓鑫",1513478681000l,1513478681000l , "1002", "李丽", "123123", "11111111111", "广东省", "广州市", "市辖区", "太撒旦", "Y", 2);
        for(int i=0;i<20;i++){
            list.add(u);
        }
        list.set(1,u2);
        return Result.success(list,20);

    }

    //删除用户信息
    @DeleteMapping("delete")
    @ResponseBody
    public HashMap deleteUser(@RequestParam("ids") String ids){
        System.out.println(ids);
        HashMap map = new HashMap();
        map.put("success",Boolean.TRUE);
        return map;
    }

    //重置密码
    @PostMapping("pwd")
    @ResponseBody
    public HashMap resetPass(@RequestParam("userId") String id){
        System.out.println(id);
        HashMap map = new HashMap();
        map.put("success",Boolean.TRUE);
        return map;
    }

    //保存和编辑
    @PostMapping("save")
    @ResponseBody
    public HashMap saveUser(User2 user){
        System.out.println(user);
        HashMap map = new HashMap();
        map.put("success",Boolean.TRUE);
        return map;
    }

    //修改状态
    @GetMapping("/lock")
    @ResponseBody
    public HashMap modifyLock(@RequestParam("userId") String userId,@RequestParam("lock") String lock){
        //'Y'是锁定
        System.out.println(userId+" === "+lock);
        HashMap map = new HashMap();
        map.put("success",Boolean.TRUE);
        return map;
    }
}
