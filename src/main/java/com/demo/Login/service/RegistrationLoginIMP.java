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
                String userLogin=userData.get(counter).getEmail()+" "+userData.get(counter).getPassword();
                String token = jwtToken.createToken(userLogin);
                return new ResponceDTO("User Login successfully  :",token);
            }
        }
        return new ResponceDTO("invalid id ",null);
    }

    @Override
    public User getUserByToken(String token) {
       String userLogin= jwtToken.decodeToken(token);
       String idPass[]=new String[2];
       idPass=userLogin.split(" ");
       String email=idPass[0];
        String password=idPass[1];
        System.out.println(email+" "+password);
        List<User> userData = userRepo.findAll();
        for(int counter=0;counter<userData.size();counter++){

            if((userData.get(counter).getEmail()).equals(email)&&(userData.get(counter).getPassword()).equals(password)){
//                String userLogin=userData.get(counter).getName()+" "+userData.get(counter).getPassword();
//                String token = jwtToken.createToken(userLogin);
//                return new ResponceDTO("User Information",userData.get(counter));
                return userData.get(counter);
            }
        }
//        return new ResponceDTO("iinvalid token",null);
    return null;
    }
}
