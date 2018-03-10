package com.mengo.api.controller;

import com.mengo.api.entity.User;
import com.mengo.api.service.UserService;
import com.mengo.api.utils.GetDataFromNet;
import com.mengo.bean.DataBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserHandler {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "user_name") String user_name, @RequestParam(value = "user_password") String user_password, HttpSession session, ModelMap modelMap) {
        User user = userService.login(user_name, user_password);
        if (user != null) {
            session.setAttribute("user", user);
            return "admin";
        } else {
            modelMap.addAttribute("message", "登录名或密码错误，请重新输入!");
            return "error";
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listAll(ModelMap modelMap, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {
        GetDataFromNet getDataFromNet = new GetDataFromNet();
        DataBean dataBean = getDataFromNet.getData(pageNo);
        modelMap.addAttribute("list_my", dataBean);
        return "list";
    }

}
