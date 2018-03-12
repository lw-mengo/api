package com.mengo.api.repository;

import com.mengo.api.entity.Bangumi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BangumiRepository  extends JpaRepository<Bangumi,Integer> {

    @Query("FROM Bangumi b WHERE b.aid=:aid")
    public Bangumi findByaid(@Param("aid")Integer aid);

    @Query("UPDATE Bangumi b SET b.url=:url WHERE b.aid=:aid")
    public Bangumi updateByaid(@Param("aid")Integer aid,@Param("url")String url);

}
