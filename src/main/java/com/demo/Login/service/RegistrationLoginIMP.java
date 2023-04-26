package com.demo.Login.service;

import com.demo.Login.Interface.IRegistrationLogin;
import com.demo.Login.dto.ResponceDTO;
import com.demo.Login.dto.UserDTO;
import com.demo.Login.model.User;
import com.demo.Login.repository.UserRepo;
import com.demo.Login.util.JWTToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationLoginIMP implements IRegistrationLogin {
    @Autowired
    private JWTToken jwtToken;
    @Autowired
    private UserRepo userRepo;
    @Override
    public ResponceDTO registeration(UserDTO userDTO) {
        User user =new User(userDTO);
        userRepo.save(user);
        return new ResponceDTO("User Data Added",user);
    }

    @Override
    public ResponceDTO login(String email,String password) {
        List<User> userData = userRepo.findAll();
        for(int counter=0;counter<userData.size();counter++){
            if((userData.get(counter).getEmail()).equals(email)&&(userData.get(counter).getPassword()).equals(password)){
                String token = jwtToken.createToken(userData.get(counter).getId());
                return new ResponceDTO("User Login successfully And Token is :"+token,userData.get(counter));
            }
        }
        return new ResponceDTO("invalid id ",null);
    }
}
