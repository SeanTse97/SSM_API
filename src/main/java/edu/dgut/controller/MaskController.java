package edu.dgut.controller;

import edu.dgut.domain.Mask;
import edu.dgut.domain.Mask2;
import edu.dgut.domain.Result;
import edu.dgut.service.MaskService;
import edu.dgut.service.UserService;
import edu.dgut.util.CompareInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@Controller
@RequestMapping("api/mask")
public class MaskController {

    @Autowired
    MaskService maskService;

    @Autowired
    UserService userService;

    @PostMapping("/list")
    @ResponseBody
    public Result getAllMaskINfo(@RequestParam ("page") String page,@RequestParam("limit") String limit,@RequestParam(value = "maskName",required = false) String maskName){
        //name是口罩名称，通过名称找订单，没有指定就找全部
        int limt = Integer.parseInt(limit);
        int start = (Integer.parseInt(page)-1) * limt;
        if(maskName == null) maskName = "";
        List<Mask> list = maskService.getMaskRecordList(start,limt,maskName);
        int count = maskService.getMRCount(maskName);
        return Result.success(list,count);
    }

    @PostMapping("/save")
    @ResponseBody
    public HashMap saveMask(@RequestParam(value = "orderId",required = false) String oid, @RequestParam(value="maskName") String maskName, @RequestParam(value = "maskNo")  String no, @RequestParam(value = "file",required = false)MultipartFile file, @CookieValue("user")String userMobile){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        String imageUrl = null;
        int no2 = Integer.parseInt(no);
        HashMap  map = new HashMap<>();
        String name = userService.getSingleUser(userMobile).getUserName();

        //将文件对象写入文件夹
        if(file != null){
            String filePath = "D://image";
            String fileName = file.getOriginalFilename();  //获取上传文件的名字
            String type = fileName.substring(fileName.lastIndexOf(".") + 1);

            //判断文件夹是否存在,不存在则创建
            File dir=new File(filePath);

            if(!dir.exists()){
                dir.mkdirs();
            }
            imageUrl = uuid+"."+type; //数据库中图片的路径
            String newFilePath=filePath+"/"+uuid+"."+type; //新文件的路径

            try {
                file.transferTo(new File(newFilePath));  //将传来的文件写入新建的文件

            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }


        //新建对象
        if(oid.length()==0){
           oid = uuid;
           String addUser = name;
           long addtime = new Date().getTime();
           long editTime = addtime;
           Mask mk = new Mask(addUser,name,addtime,editTime,oid,maskName,no2,imageUrl);
           int i = maskService.saveMask(mk);
           if(i==1){
               List<Mask2> mkl2 = maskService.getMaskStore(maskName);
               if(mkl2.size() > 0){
                    no2 = no2 + mkl2.get(0).getMaskNo();
                    maskService.updateMaskStore(maskName,mk.getEditTime(),no2,mk.getImageUrl());
               }else{
                   Mask2 mk2 = new Mask2(maskName,addtime,no2,imageUrl);
                   maskService.saveMaskStockInfo(mk2);
               }
               map.put("success",Boolean.TRUE);
               map.put("msg","保存成功");
           }else{
               map.put("success",Boolean.FALSE);
               map.put("msg","保存失败");
           }

        }else{
            //更新操作
            //更新的对象
            List<Mask> mkl = maskService.getMaskRecordList(0,10,maskName);
            Mask u1 = mkl.get(0);
            if(file != null) {
                File file2 = new File("D://image/" + u1.getImageUrl());
                if (file2.exists()) {
                    file2.delete();
                }
            }
            int n1 = u1.getMaskNo();
            long edittime2 = new Date().getTime();

            //前端产生的新对象
            Mask u2 = new Mask("",name,0,edittime2,oid,maskName,no2,imageUrl);

            CompareInfoUtil<Mask> comp =  new CompareInfoUtil<>(u1,u2);

            //对比产生的对象
            u1 = comp.compare1to2();

            maskService.updateMaskInfo(u1);
            maskService.updateMaskStore(maskName,u1.getEditTime(),no2 - n1,u1.getImageUrl());

            map.put("success",Boolean.TRUE);
            map.put("msg","更新成功");
        }

        return map;
    }



    @PostMapping("/delete")
    @ResponseBody
    public HashMap delMask(@RequestParam("ids") String oid, HttpServletRequest request){
        HashMap  map = new HashMap<>();
        int i = maskService.deleteMaskInfo(oid);
        if(i == 1){
            map.put("success",Boolean.TRUE);
            map.put("msg","删除成功");
        }else{
            map.put("success",Boolean.FALSE);
            map.put("msg","删除失败");
        }


        return map;
    }

    @PostMapping("/kindList")
    @ResponseBody
    public Result allKindMask(){
        List<Mask2> list = new LinkedList<>();
        list = maskService.getMaskStore("");
        return Result.success(list,list.size());
    }

    @GetMapping("/images")
    public String getpic(@RequestParam("imageUrl") String path, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg/jpg/png/gif/bmp/tiff/svg"); // 设置返回内容格式
        path=new String(path.getBytes("ISO-8859-1"),"UTF-8");
        File file = new File("D://image/"+path);       //括号里参数为文件图片路径
        if(file.exists()){   //如果文件存在
            InputStream in = new FileInputStream("D://image/"+path);   //用该文件创建一个输入流
            OutputStream os = response.getOutputStream();  //创建输出流
            byte[] b = new byte[1024];
            while( in.read(b)!= -1){
                os.write(b);
            }
            in.close();
            os.flush();
            os.close();
        }
        return null;
    }

}
