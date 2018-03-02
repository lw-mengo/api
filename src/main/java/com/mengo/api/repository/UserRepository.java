package com.mengo.api.repository;

import com.mengo.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("from User u where u.username=:username and u.password=:password")
    public User getByNameAndPassword(@Param("username")String username,@Param("password")String password);


}
