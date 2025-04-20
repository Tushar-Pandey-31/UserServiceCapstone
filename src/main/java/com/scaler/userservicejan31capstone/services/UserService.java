package com.scaler.userservicejan31capstone.services;

import com.scaler.userservicejan31capstone.models.Token;
import com.scaler.userservicejan31capstone.models.User;

public interface UserService
{
    User signUp(String name, String email , String Password);
    Token login(String email, String password);
    void logout(String tokenValue);
    User validateToken(String tokenValue);
}
