package com.test.web.controller;

import com.test.web.entity.UserEntity;
import com.test.web.service.MainService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping
    public String Home(){
        return "Hello i'm Home Page";
    }

    @PostMapping("/add")
    public UserEntity add(@Valid @RequestBody UserEntity user) {
        return mainService.addUser(user.getName(),user.getEmail());
    }

    @GetMapping("/view")
    public List<UserEntity> view(){
        return mainService.getAllUser();
    }

    @PutMapping("/update")
    public UserEntity update(@Valid @RequestBody UserEntity user){
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        return mainService.updateUser(user.getId(),user.getName(),user.getEmail());
    }

    @DeleteMapping("/delete")
    public UserEntity delete(@RequestParam Long id){
        return mainService.deleteUser(id);
    }

}
