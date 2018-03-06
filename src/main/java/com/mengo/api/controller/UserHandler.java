package com.mengo.api.controller;

import com.google.gson.Gson;
import com.mengo.api.entity.User;
import com.mengo.api.service.UserService;
import com.mengo.api.utils.GetDataFromNet;
import com.mengo.bean.DataBean;
import com.mengo.bean.VideoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class UserHandler {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(value = "user_name")String user_name, @RequestParam(value = "user_password")String user_password, HttpSession session, ModelAndView mv){
        User user = userService.login(user_name,user_password);
        if (user!=null){
            session.setAttribute("user",user);
            mv.setViewName("/admin");
        }else {
            mv.addObject("message","登录名或密码错误，请重新输入!");
            mv.setViewName("/error");
        }
        return mv;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String  listAll(ModelMap modelMap,@RequestParam(value = "pageNo",defaultValue = "1")int pageNo){
        GetDataFromNet getDataFromNet = new GetDataFromNet();
        DataBean dataBean = getDataFromNet.getData(pageNo);
        modelMap.addAttribute("list_my",dataBean);
        return "list";
    }
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public String listDetail(@RequestParam(value = "s")String s,ModelMap modelMap){
        GetDataFromNet getDataFromNet = new GetDataFromNet();
        VideoBean videoBean = getDataFromNet.getInfo(s);
        modelMap.addAttribute("detail_info",videoBean);
        return "detail";
    }
}
