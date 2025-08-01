package com.foro.foroAlura.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements UserService {


    @Autowired
    private userRepository userRepository;


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

}
