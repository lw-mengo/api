package com.mengo.api.service;

import com.mengo.api.entity.Bangumi;
import com.mengo.api.repository.BangumiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BangumiService {
    @Autowired
    private BangumiRepository bangumiRepository;

    @Transactional
    public void save(Bangumi bangumi){
        //id为空表示新添加的
//        if (bangumi.getId()==null){
//            bangumi.setUrl();
//        }
       bangumiRepository.saveAndFlush(bangumi);
    }

    @Transactional(readOnly = true)
    public Page<Bangumi> listAll(Integer pageNo,Integer pageSize){
        PageRequest pageRequest =PageRequest.of(pageNo-1,pageSize);//注意减1，数组是从0开始，除非你赋值也是从0开始
        Page<Bangumi> page = bangumiRepository.findAll(pageRequest);
        return page;
    }

    @Transactional
    public Bangumi findByAid(Integer aid){
        Bangumi bangumi = bangumiRepository.findByaid(aid);
        return bangumi;
    }

    @Transactional
    public void delete(Integer id){
        bangumiRepository.deleteById(id);
        bangumiRepository.flush();
    }

    @Transactional
    public Bangumi updateByaid(Integer aid,String url){
        Bangumi bangumi = bangumiRepository.updateByaid(aid,url);
        return bangumi;
    }


}
