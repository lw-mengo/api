package com.mengo.api.service;

import com.mengo.api.entity.User;
import com.mengo.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User login(String username,String password){
        return userRepository.getByNameAndPassword(username,password);
    }
}
