package com.example.Consultorio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String home(){
        return "<h1> Seja bem vindo </h1>";
    }

    @GetMapping("/user")
    public String user(){
        return "<h1> Seja bem vindo Usuario </h1>";
    }

    @GetMapping("/admin")
    public String admin(){
        return "<h1> Seja bem vindo Admin</h1>";
    }

}