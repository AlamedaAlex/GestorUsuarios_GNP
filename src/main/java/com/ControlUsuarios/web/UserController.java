package com.ControlUsuarios.web;

import com.ControlUsuarios.persitence.entity.UserEntity;
import com.ControlUsuarios.service.UserServer;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/user/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable String id) {
        return ResponseEntity.ok(userServer.getUserById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<UserEntity> save(@RequestBody UserEntity user) {
        if (user.getUsername() == null || this.userServer.exist(user.getUsername())) {
            return ResponseEntity.ok(this.userServer.save(user));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<UserEntity> update(@RequestBody UserEntity user) {
        if(user.getUsername()!=null || this.userServer.exist(user.getUsername())){
            return ResponseEntity.ok(this.userServer.save(user));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<Void> delete(@RequestParam String username){
        if(userServer.exist(username)){
            this.userServer.delete(username);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
