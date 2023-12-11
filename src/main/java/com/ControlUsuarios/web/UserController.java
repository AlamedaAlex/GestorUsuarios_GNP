package com.ControlUsuarios.web;

import com.ControlUsuarios.persitence.entity.UserEntity;
import com.ControlUsuarios.service.UserServer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserServer userServer;

    public UserController(UserServer userServer) {
        this.userServer = userServer;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAll() {
        return ResponseEntity.ok(userServer.getAll());
    }
}
