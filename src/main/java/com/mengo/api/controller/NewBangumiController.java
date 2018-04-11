package com.mengo.api.controller;

import com.google.gson.Gson;
import com.mengo.api.entity.NewBangumi;
import com.mengo.api.service.NewBangumiService;
import com.mengo.api.utils.GetDataFromNet;
import com.mengo.bean.VideoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

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


    /*
    api接口，返回新番的json数据
     */
    @ResponseBody
    @RequestMapping(value = "/subject/new/{aid}",method = RequestMethod.GET,produces = {"application/json;charset=utf-8"})
    public ResponseEntity<NewBangumi> api(@PathVariable(value = "aid")Integer aid, HttpServletResponse response){
        NewBangumi newBangumi = newBangumiService.findByid(aid);
        response.setHeader("Access-Control-Allow-Origin","*");
        if (newBangumi!=null) {
            return new ResponseEntity<>(newBangumi, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*
    更新新番数据页面
     */
    @RequestMapping(value = "/update_new/{aid}",method = RequestMethod.GET)
    public String update(@PathVariable(value = "aid")Integer aid,ModelMap modelMap){
        Gson gson = new Gson();
        GetDataFromNet getDataFromNet = new GetDataFromNet();
        NewBangumi newBangumi = newBangumiService.findByid(aid);
        VideoBean videoBean = getDataFromNet.getInfo(newBangumi.getSource_url());
        String temp = gson.toJson(videoBean,VideoBean.class);
        int newNum = videoBean.getEpisodeList().size();
        modelMap.addAttribute("aid",aid);
        modelMap.addAttribute("bangumi",newBangumi);
        modelMap.addAttribute("json_url",temp);
        modelMap.addAttribute("newNum",newNum);
        return "new_bangumi/update";
    }




}
