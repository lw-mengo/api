package com.mengo.api.controller;

import com.google.gson.Gson;
import com.mengo.api.entity.NewBangumi;
import com.mengo.api.service.NewBangumiService;
import com.mengo.api.utils.GetDataFromNet;
import com.mengo.bean.VideoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewBangumiController {
    @Autowired
    private NewBangumiService newBangumiService;

    /*
    跳转到详情添加页面
     */
    @RequestMapping(value = "/add_new",method = RequestMethod.GET)
    public String listDetail(@RequestParam(value = "s")String s, ModelMap modelMap){
        GetDataFromNet getDataFromNet = new GetDataFromNet();
        Gson gson = new Gson();
        VideoBean videoBean = getDataFromNet.getInfo(s);
        String temp = gson.toJson(videoBean,VideoBean.class);
        modelMap.addAttribute("json_url",temp);
        modelMap.addAttribute("detail",videoBean);
        modelMap.addAttribute("bangumi",new NewBangumi());

        return "/new_bangumi/add_new";
    }

    /*
    表单的提交action，新番保存到数据库
     */
    @RequestMapping(value = "/save_new_bangumi",method = RequestMethod.POST)
    public String save(NewBangumi newBangumi){
        newBangumiService.save(newBangumi);
        return "redirect:/list";
    }

    /*
    分页列出数据库的新番数据
     */
    @RequestMapping(value = "/new_bangumi_list",method = RequestMethod.GET)
    public String listAll(@RequestParam(value = "pageNo",required = false,defaultValue = "1")String pageNoStr,ModelMap modelMap){
        int pageNo = Integer.parseInt(pageNoStr);
        if (pageNo<1){
            pageNo=1;
        }
        Page<NewBangumi> page = newBangumiService.listAll(pageNo,10);
        modelMap.addAttribute("page",page);
        return "new_bangumi/list";
    }


}
