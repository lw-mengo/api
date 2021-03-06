package com.mengo.api.controller;

import com.google.gson.Gson;
import com.mengo.api.entity.Bangumi;
import com.mengo.api.service.BangumiService;
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
public class BangumiHandler {
    @Autowired
    private BangumiService bangumiService;

    /*
    分页列出数据库中所有的番剧
     */
    @RequestMapping(value = "/bangumi/list", method = RequestMethod.GET)
    public String listAll(@RequestParam(value = "pageNo", required = false, defaultValue = "1") String pageNoStr, ModelMap modelMap) {
        int pageNo = Integer.parseInt(pageNoStr);
        if (pageNo < 1) {
            pageNo = 1;
        }
        Page<Bangumi> page = bangumiService.listAll(pageNo, 10);
        modelMap.addAttribute("page", page);
        return "bangumi/list";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String listDetail(@RequestParam(value = "s") String s, ModelMap modelMap) {
        GetDataFromNet getDataFromNet = new GetDataFromNet();
        Gson gson = new Gson();
        VideoBean videoBean = getDataFromNet.getInfo(s);
        String temp = gson.toJson(videoBean, VideoBean.class);
        modelMap.addAttribute("json_url", temp);
        modelMap.addAttribute("detail_info", videoBean);
        modelMap.addAttribute("bangumi", new Bangumi());
        return "detail";
    }


    /*
    保存番剧数据
     */
    @RequestMapping(value = "/save_bangumi", method = RequestMethod.POST)
    public String save(Bangumi bangumi) {
        bangumiService.save(bangumi);
        return "redirect:/bangumi/list";
    }


    /*
    更新番剧数据
     */
    @RequestMapping(value = "/update_bangumi", method = RequestMethod.PUT)
    public String update(@ModelAttribute("bangumi") Bangumi bangumi) {
        String url = bangumi.getUrl();
        Integer aid = bangumi.getAid();
        bangumiService.updateByaid(aid, url);
        return "redirect:/bangumi/list";
    }

    @RequestMapping(value = "/update_bangumi/{aid}", method = RequestMethod.GET)
    public String update(@PathVariable(value = "aid") Integer aid, ModelMap modelMap) {
        Gson gson = new Gson();
        GetDataFromNet getDataFromNet = new GetDataFromNet();
        Bangumi bangumi = bangumiService.findByAid(aid);
        VideoBean videoBean = getDataFromNet.getInfo(bangumi.getSource_url());
        String temp = gson.toJson(videoBean, VideoBean.class);
        int newNum = videoBean.getEpisodeList().size();
        modelMap.addAttribute("aid", aid);
        modelMap.addAttribute("bangumi", bangumi);
        modelMap.addAttribute("json_url", temp);
        modelMap.addAttribute("newNum", newNum);
        return "bangumi/update";
    }

    @RequestMapping(value = "/bangumi/list/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Integer id) {
        bangumiService.delete(id);
        return "redirect:/bangumi/list";
    }

    /*
    api接口发返回json数据
     */
    @ResponseBody
    @RequestMapping(value = "/subject/{aid}", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    public ResponseEntity<Bangumi> api(@PathVariable(value = "aid") Integer aid, HttpServletResponse response) {
//        Gson gson = new Gson();
        Bangumi bangumi = bangumiService.findByAid(aid);
//        String temp = gson.toJson(bangumi, Bangumi.class);
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (bangumi != null) {
            return new ResponseEntity<>(bangumi, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
