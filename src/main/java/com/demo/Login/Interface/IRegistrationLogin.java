package com.demo.Login.Interface;

import com.demo.Login.dto.ResponceDTO;
import com.demo.Login.dto.UserDTO;

public interface IRegistrationLogin {
    public ResponceDTO registeration(UserDTO userDTO);
    public ResponceDTO login(String email,String password);

}
