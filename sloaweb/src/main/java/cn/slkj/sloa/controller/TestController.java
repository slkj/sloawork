package cn.slkj.sloa.controller;

import cn.slkj.sloa.mapper.UserMapper;
import cn.slkj.sloa.model.User;
import cn.slkj.sloa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
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
    @Resource
    private IUserService userService;

    @RequestMapping("/showUser")
    @ResponseBody
    public User toIndex(HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        System.out.println("=================" + user.getUser_name());
        User user1 = this.userService.getUserById1(userId);
        System.out.println("=================" + user1.getUser_name());

        return user;
    }


}