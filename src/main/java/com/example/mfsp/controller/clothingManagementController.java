package com.example.mfsp.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.mfsp.entity.Clothing;
import com.example.mfsp.service.clothingService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.jstl.sql.Result;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class clothingManagementController {

    @Autowired
    private clothingService clothingservice;
    private Object ResultCodeConstants;


    /*根据服装序号查找服装*/
    @RequestMapping(value="/SelectClothingById",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> SelectClothingById(@RequestParam("clothingid")  Integer id) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        Clothing clothing=new Clothing();
        clothing.setClothingid(id);
        List<Clothing> clothings=new ArrayList<>();
        if(clothing.getClothingid()==0){
            clothings=clothingservice.selectAll();
        }else{
            clothings=clothingservice.selectAll(clothing);
        }
        result.put("count",clothings.size());
        result.put("data", clothings);
      /*  System.out.println("endddd");
        System.out.println(id);*/
        return result;
    }

    /*查询全部服装*/
    @RequestMapping(value="/SelectAllClothing", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> SelectAllClothing() {
        Map<String, Object> clothingresult = new HashMap<String, Object>();
        clothingresult.put("code", 0);
        clothingresult.put("msg", "");

        List<Clothing> clothings=new ArrayList<>();
        clothings=clothingservice.selectAll();
        clothingresult.put("count",clothings.size());
        clothingresult.put("data", clothings);
        System.out.println("All clothings is selected ");

        System.out.println("orderforms.get(0);"+clothings.get(0).getClothingid()+clothings.get(0).getClothingname());
        return clothingresult;
    }

    /*修改服装信息
    * 返回情况不清楚*/
    @RequestMapping(value="/updateClothing",method= RequestMethod.GET)
    public String updateClothing(Clothing clothing){

        System.out.println(clothing.getClothingid());
        clothingservice.updateByPrimaryKeySelective(clothing);


       /* String T=clothing.toString();
        System.out.println(T);*/
        return "success";
    }

    /*添加服装信息
    返回情况不清楚
    */
    @RequestMapping(value = "/addClothing",method=RequestMethod.GET)
    @ResponseBody
    public void addClothing( Clothing clothing){

        System.out.println(clothing.getClothingpic());
        clothingservice.insert(clothing);

    }

    /*删除服装信息
    返回情况不清楚
     */

    @GetMapping("/deleteByID")
    @ResponseBody
    public String deleteByID(Clothing clothing){

        System.out.println("del"+ clothing.toString());
        if(clothing.getClothingid()==null){
            System.out.println("clothing.getClothingid()==null");
        }else {
            System.out.println("clothing.getClothingid()==nonull");
            clothingservice.delete(clothing);
        }
        return "success";
    }


    /*测试模块*/
    @RequestMapping(value="/Test",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> test(){
        Clothing clothing01=new Clothing();

       /* clothing01.setClothingname("棉裤");
        clothing01.setClothingcost("12");
        clothing01.setClothingprice("100");
        clothing01.setClothingrentprice("10");
        clothing01.setClothingnum(20);
        clothingservice.insert(clothing01);*/

        clothing01.setClothingid(3);
        clothingservice.delete(clothing01);

        List<Clothing> clothings=new ArrayList<>();
        clothings=clothingservice.selectAll();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count",clothings.size());
        result.put("data", clothings);

        String c=clothing01.toString();
        System.out.println("clothing01:"+c);


        return result;
    }

    @RequestMapping(value="/FuzzySearchClothing", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> FuzzySearchClothing(@RequestParam("name")  String clothingname){

        Map<String, Object> result = new HashMap<String, Object>();
        List<Clothing> clothings=new ArrayList<>();
        System.out.println(clothingname);
        clothings=clothingservice.FuzzySearchClothing(clothingname);
        result.put("code", 0);
        result.put("msg", "");
        result.put("count",clothings.size());
        result.put("data", clothings);

        return result;
    }


    @ResponseBody
    @RequestMapping("/upload")
    public JSONObject upload(/*@RequestParam("clothingpic")*/MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException, JSONException {
        JSONObject res = new JSONObject();
        JSONObject resUrl = new JSONObject();

        //String path = request.getSession().getServletContext().getRealPath("upload");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式  HH:mm:ss
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        /*路径*/
        String path = "C:\\Users\\风\\Desktop\\mfsp01\\src\\main\\webapp\\images\\photo";
        /*为命名准备*/
        UUID uuid=UUID.randomUUID();
        String originalFilename = file.getOriginalFilename();  /*应该是获取原始文件名*/
        // String fileName = uuid.toString() + originalFilename;
        /*拓展名 */
        String extendName = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());

        /*新文件名*/
        String fileName = uuid.toString() + extendName;
        /*封装上传图片位置的全路径*/
        File dir = new File(path+fileName);
        /**/
        File filepath = new File(path);
        System.out.println("路径=="+filepath.getParentFile());
        if(!filepath.getParentFile().exists()){
            filepath.getParentFile().mkdirs();
        }else{
            System.out.println(filepath.getParentFile());
        }
//        if(!filepath.exists()) {
        //把本地文件上传到封装上传文件位置的全路径
        //使用transferTo(dest)方法将上传文件写到服务器上指定的文件;
        file.transferTo(dir);
        //获得当前项目所在路径
        String pathRoot=request.getSession().getServletContext().getRealPath("");
        System.out.println("当前项目所在路径："+pathRoot);

        String sqlFile = "\\images\\photo"+fileName;
        /*Clothing clothing =new Clothing();
        clothing.setClothingpic(sqlFile);
        clothingservice.insert(clothing);*/
//        }
        resUrl.put("src", sqlFile);
        res.put("code", 0);
        res.put("msg", "上传成功");
        res.put("data", resUrl);
        String str="";
        str = "{\"code\": 0,\"msg\": \"\",\"data\": {\"src\":\"" +dir + "\"}}";

        System.out.println(str);
        return res;

        /*Map<String, String> map = new HashMap<>();
        map.put("filePath", path);
        map.put("fileName", fileName);

        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", "上传成功");
        result.put("count", 1);
        result.put("data", map);
        return result;*/

    }

}
