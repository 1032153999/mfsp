package com.example.mfsp.controller;

import com.example.mfsp.entity.User;
import com.example.mfsp.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: SessionController
 * @Description:
 * @Author
 * @Date 2020/12/03
 * @Version 1.0
 */

@Controller
public class SessionController {

    @Autowired
    private userService userService;

    @RequestMapping(value = "QueryUserSession")
    @ResponseBody
    public Map<String, Object> queryUserSession(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        HttpSession session = httpServletRequest.getSession();
        Integer user_id = (Integer) session.getAttribute("USER_SESSION");
        if(user_id==null){

        }else {
            User user = new User();
            user.setUserid(user_id);
            List<User> users=userService.selectAll(user);
            result.put("data",users);
            result.put("count",users.size());
        }


        System.out.println(result.toString());

        return result;
    }
}
