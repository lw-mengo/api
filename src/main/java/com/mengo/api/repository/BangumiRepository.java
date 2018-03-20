package com.mengo.api.repository;

import com.mengo.api.entity.Bangumi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BangumiRepository  extends JpaRepository<Bangumi,Integer> {

    @Query("FROM Bangumi b WHERE b.aid=:aid")
    Bangumi findByaid(@Param("aid")Integer aid);

    @Transactional
    @Modifying
    @Query("UPDATE Bangumi b SET b.url=:url WHERE b.aid=:aid")
    void updateByaid(@Param("aid")Integer aid,@Param("url")String url);

}
