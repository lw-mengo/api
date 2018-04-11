package com.mengo.api.repository;

import com.mengo.api.entity.NewBangumi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NewBangumiRepository extends JpaRepository<NewBangumi,Integer> {
    /*
    自定义id查询，返回json数据的
     */
    @Query("from NewBangumi n where n.aid=:aid")
    NewBangumi findByAid(@Param("aid")Integer aid);
}
