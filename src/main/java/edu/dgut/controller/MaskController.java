package edu.dgut.controller;

import edu.dgut.domain.Mask;
import edu.dgut.domain.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("api/mask")
public class MaskController {
    @PostMapping("/list")
    @ResponseBody
    public Result getAllMaskINfo(@RequestParam ("page") String page,@RequestParam("limit") String limit,@RequestParam(value = "maskName",required = false) String name){
        System.out.println(page+"<====>"+limit+"==>"+name);
        //name是口罩名称，通过名称找订单，没有指定就找全部

        List<Mask> maskList = new LinkedList<>();
        Mask s = new Mask("null","null",1521062371000l,1521062371000l,"132123","N95","100");
        for (int i=0;i<10;i++){
            maskList.add(s);
        }
        return Result.success(maskList,101);
    }
    @PostMapping("/save")
    @ResponseBody
    public HashMap saveMask(@RequestParam(value = "orderId",required = false) String oid, @RequestParam("maskName") String name, @RequestParam("maskNo")  String no){
        System.out.println(oid+"==>"+name+"==>"+no);
//        if(oid == null){
//            新增信息
//        }else{
//            更新信息
//        }
        HashMap  map = new HashMap<>();
        map.put("success",Boolean.TRUE);
        map.put("msg","保存成功");
        return map;
    }
    @PostMapping("/delete")
    @ResponseBody
    public HashMap delMask(@RequestParam("ids") String oid, HttpServletRequest request){
        HashMap  map = new HashMap<>();
        map.put("success",Boolean.TRUE);
        map.put("msg","删除成功");
        return map;
    }
}
