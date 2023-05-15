package com.demo.Login.controller;

import com.demo.Login.Interface.IRegistrationLogin;
import com.demo.Login.dto.ResponceDTO;
import com.demo.Login.dto.UserDTO;
import com.demo.Login.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/RL")
public class RegistrationLoginController {
    @Autowired
    private IRegistrationLogin iRegistrationLogin;
    @GetMapping("/")
    public String getIndexpage(){
    return "Hello";
}
    @PostMapping("/register")
    public ResponceDTO userRegisteration(@RequestBody UserDTO userDTO){
        return iRegistrationLogin.registeration(userDTO);
    }
    @GetMapping("/login")
    public ResponceDTO login(@RequestParam String email,@RequestParam String password){
        return iRegistrationLogin.login(email,password);
    }
    @GetMapping("/getByToken")
    public ResponceDTO getUserByToken(@RequestHeader String token){
        User user=iRegistrationLogin.getUserByToken(token);
        ResponceDTO responceDTO =new ResponceDTO("User Data Found",user);
        return responceDTO;
    }
}
