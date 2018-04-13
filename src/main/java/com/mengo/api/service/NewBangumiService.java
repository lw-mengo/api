package com.mengo.api.service;

import com.mengo.api.entity.NewBangumi;
import com.mengo.api.repository.NewBangumiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NewBangumiService {
    @Autowired
    private NewBangumiRepository newBangumiRepository;

    /*
    保存新番数据
     */
    @Transactional
    public void save(NewBangumi newBangumi){
        newBangumiRepository.saveAndFlush(newBangumi);
    }

    /*
    分页列出新番数据
     */
    @Transactional(readOnly = true)
    public Page<NewBangumi> listAll(Integer pageNo,Integer pageSize){
        PageRequest pageRequest = PageRequest.of(pageNo-1,pageSize);
        Page<NewBangumi> page = newBangumiRepository.findAll(pageRequest);
        return page;
    }

    /*
    利用id查询的事务
     */
    @Transactional
    public NewBangumi findByid(Integer aid){
        NewBangumi newBangumi = newBangumiRepository.findByAid(aid);
        return newBangumi;
    }

    /*
    更新数据
     */
    public void updateByaid(Integer aid,String url){
        newBangumiRepository.updateByaid(aid,url);
        newBangumiRepository.flush();
    }
}
