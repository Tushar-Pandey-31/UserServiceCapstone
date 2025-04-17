package com.scaler.userservicejan31capstone.services;

import com.scaler.userservicejan31capstone.models.Token;
import com.scaler.userservicejan31capstone.models.User;
import com.scaler.userservicejan31capstone.repositories.TokenRepository;
import com.scaler.userservicejan31capstone.repositories.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService
{
    BCryptPasswordEncoder bCryptPasswordEncoder;
    UserRepository userRepository;
    TokenRepository tokenRepository;

    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder,
                           TokenRepository tokenRepository)
    {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenRepository = tokenRepository;

    }

    @Override
    public User signup(String name, String email, String Password) {

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(Password));

        return userRepository.save(user);
    }

    @Override
    public Token login(String email, String password) {
        Optional<User> optionalUser =  userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            //throw exception or redirect to login
            return null;
        }
        User user = optionalUser.get();
        if (!bCryptPasswordEncoder.matches(password, user.getPassword()))
        {
            return null;
        }
        Token token = new Token();
        token.setUser(user);
        token.setValue(RandomStringUtils.randomAlphanumeric(128));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 30);
        Date date = calendar.getTime();

        token.setExpiryAt(date);
        return tokenRepository.save(token);

    }

    @Override
    public void logout(String tokenValue) {

    }

    @Override
    public User validateToken(String token) {
        return null;
    }
}
