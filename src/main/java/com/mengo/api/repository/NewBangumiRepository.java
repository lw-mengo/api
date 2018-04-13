package com.mengo.api.repository;

import com.mengo.api.entity.NewBangumi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface NewBangumiRepository extends JpaRepository<NewBangumi,Integer> {
    /*
    自定义id查询，返回json数据的
     */
    @Query("from NewBangumi n where n.aid=:aid")
    NewBangumi findByAid(@Param("aid")Integer aid);

    /*
    更新番剧
     */
    @Transactional
    @Modifying
    @Query("UPDATE NewBangumi n SET n.video_url=:url WHERE n.aid=:aid")
    void updateByaid(@Param("aid")Integer aid,@Param("url")String url);
}
