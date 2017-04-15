package cn.slkj.sloa.controller;

import cn.slkj.sloa.mapper.UserMapper;
import cn.slkj.sloa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javafx.scene.input.KeyCode.U;

/**
 * Created by maxh on 2017-04-15.
 */
@RestController
@RequestMapping(value = "/api_cat")
public class TestController {
    @Autowired
    UserMapper userMapper;

    @ResponseBody
    @RequestMapping("/test")
    public String helloWorld() {

        String message = "<br><div style='text-align:center;'>"
                + "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CityController.java **********</div><br><br>";
        return message;
    }


    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request, Map model) {
        //String name=request.getParameter("name");
        //model.put("name", name);
        User u = new User();
        u.setUsername("admin");
        u.setPassword("admin");
        User user = userMapper.selectUser(u);
        model.put("user", user);
        return "hi";
    }

    @RequestMapping(value = "/text")
    @ResponseBody
    public String text(HttpServletRequest request) {
        return "{\"what\":\"hi\"}";
    }

    @RequestMapping(value = "/indexList")
    public String indexList(HttpServletRequest request, Map model) {
        List<User> userList = userMapper.selectUserLsit();
        model.put("userList", userList);
        return "hiList";
    }


}