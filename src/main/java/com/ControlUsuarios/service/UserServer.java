package com.ControlUsuarios.service;

import com.ControlUsuarios.persitence.entity.UserEntity;
import com.ControlUsuarios.persitence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServer {

private final UserRepository userRepository;

@Autowired
    public UserServer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAll(){
        List<UserEntity> users = this.userRepository.findAll();
        return users;
    }
}
