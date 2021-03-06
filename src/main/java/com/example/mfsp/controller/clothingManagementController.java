package com.example.mfsp.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.mfsp.entity.Clothing;
import com.example.mfsp.service.clothingService;
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
        if( clothing.getClothingid()==null) {
            clothings = clothingservice.selectAll();
        } else {
            if (clothing.getClothingid() == 0) {
                clothings = clothingservice.selectAll();
            } else {
                clothings = clothingservice.selectAll(clothing);
            }

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
    public String addClothing( Clothing clothing){

        Clothing clothingquery=new Clothing();
        Integer clothingid=clothing.getClothingid();
        clothingquery.setClothingid(clothingid);
        List<Clothing> clothings=clothingservice.selectAll(clothingquery);
        System.out.println(clothings.size());
        if(clothings.size()>0){
            System.out.println("defealt to insert");
            return "defealt to insert";
        }else{
            clothingservice.insert(clothing);
            return "success to insert";
        }

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

    /*根据服装名称的模糊查询*/
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
    public JSONObject upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException, JSONException {
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
        //把本地文件上传到封装上传文件位置的全路径
        //使用transferTo(dest)方法将上传文件写到服务器上指定的文件;
        file.transferTo(dir);
        //获得当前项目所在路径
        String pathRoot=request.getSession().getServletContext().getRealPath("");
        System.out.println("当前项目所在路径："+pathRoot);

        String sqlFile = "\\images\\photo"+fileName;
        resUrl.put("src", sqlFile);
        res.put("code", 0);
        res.put("msg", "上传成功");
        res.put("data", resUrl);
        String str="";
        str = "{\"code\": 0,\"msg\": \"\",\"data\": {\"src\":\"" +dir + "\"}}";

        System.out.println(str);
        return res;

    }


    /**FirstKind(),SecondKind(),ThirdlyKind()
     *通过三个controller来获取服装的三级类别
     *
     * 下拉框动态获取第一类
     * @return
     */
    @RequestMapping(value = "queryFirstKind" , method=RequestMethod.GET)
    @ResponseBody
    public String findFirstKind(){

        /*        System.out.println(clothingservice.findFirstKind());*/
        System.out.println("已经进入");
        List<String> list=new ArrayList<String>();
        System.out.println("222");
        list=clothingservice.findFirstKind();
        String result= String.join(",",list);
        System.out.println(result);
        return result;
    }

    /*获取第二类*/

    @RequestMapping(value = "querySecondKind", method=RequestMethod.GET)
    @ResponseBody
    public String findSecondKind(String FirstKind){
        System.out.println("二级进入");
        List<String> list=new ArrayList<String>();
        list=clothingservice.findSecondKind(FirstKind);
        String result=  String.join(",",list);
        System.out.println(result);
        return result;
    }

    /*
     * 获取第三类
     * */
    @RequestMapping(value="queryThirdlyKind", method=RequestMethod.GET)
    @ResponseBody
    public String findThirdlyKind(String FirstKind,String SecondKind){
        List<String> list=new ArrayList<String>();
        list=clothingservice.findThirdlyKind(FirstKind,SecondKind);
        String result=  String.join(",",list);
        System.out.println(result);
        return result;
    }




}
