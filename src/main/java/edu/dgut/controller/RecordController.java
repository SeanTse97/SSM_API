package edu.dgut.controller;

import edu.dgut.domain.Record;
import edu.dgut.domain.Result;
import edu.dgut.mapper.RecordMapper;
import edu.dgut.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("api/order")
public class RecordController {
    /**
     *         page: 1,
     *         limit: 10,
     *         applyId: '',
     *         userId: '',
     *         applyStatus: 0,
     * @return
     */
    @Autowired
    RecordService recordService;
    @PostMapping("/list")
    @ResponseBody
    public Result getAll(@RequestParam("page")String page,@RequestParam("limit")String limit,
                         @RequestParam(value = "applyId",required = false) String aid,@RequestParam(value = "userId",required = false) String uid,
                         @RequestParam(value = "applyStatus",required = false) String status){
        /*System.out.println(page+"=="+limit+"=="+aid+"=="+uid+"=="+status);
        List<Record> list= new LinkedList<>();
        Record rd = new Record("13213123131323","小明","12121","N95","9583",10,1521062371000l,1521062371000l,"pass","");
        for(int i=0;i<11;i++){
            list.add(rd);
        }*/
        int limt = Integer.parseInt(limit);
        int start = (Integer.parseInt(page)-1) * limt;

        List<Record> list=recordService.getRecordList(start,limt,aid,uid,status);
        int count=recordService.getRecordCount(aid,uid,status);

        return Result.success(list,count);
    }

    @PostMapping("/modify")
    @ResponseBody
    public HashMap modifyStatus(@RequestParam("applyId")String applyId,@RequestParam("applyStatus")String status){
        //System.out.println(applyId+"<====>"+status);
        HashMap map = new HashMap();
        Record record=recordService.getRecordById(applyId);
        //System.out.println(record);
        record.setEditTime(new Date().getTime());
        record.setApplyStatus(status);
        int i= recordService.updateRecord(record);

        if( i == 1){
            map.put("success",Boolean.TRUE);
        }else{
            map.put("success",Boolean.FALSE);
            map.put("msg","服务端出错了！请稍候重试！！");
        }
        //map.put("success",Boolean.TRUE);
        return map;
    }


    @DeleteMapping("/delete")
    @ResponseBody
    public HashMap deleteRecord(@RequestParam("ids") String id){
        System.out.println(id);
        int i =recordService.deleteRecord(id);
        HashMap map = new HashMap();
        //map.put("success",Boolean.TRUE);
        if(i == 1){
            map.put("success",Boolean.TRUE);
        }else{
            map.put("success",Boolean.FALSE);
        }
        return map;
    }
}
