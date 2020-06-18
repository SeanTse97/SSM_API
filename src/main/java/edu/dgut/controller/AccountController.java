package edu.dgut.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import edu.dgut.domain.User;
import edu.dgut.domain.User2;
import edu.dgut.service.AccountService;
import edu.dgut.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/api")
public class AccountController {

    @Autowired
    AccountService accountService;


    @PostMapping("/province/list")
    @ResponseBody
    public JSONArray getAllProvince(){
        String path = AccountController.class.getClassLoader().getResource("map.json").getPath();;
        String s = JsonUtil.readJsonFile(path);
        JSONArray jarr = JSON.parseArray(s);
        return jarr;

    }

    @PostMapping("/updateUserInfo")
    @ResponseBody
    public HashMap updateUserInfo(User2 user){
        System.out.println(user.toString());
        HashMap map = new HashMap();
        map.put("success",Boolean.TRUE);
        return map;
    }

}
