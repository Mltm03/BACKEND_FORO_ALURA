package com.foro.foroAlura.domain.user.dto;

import com.foro.foroAlura.domain.user.User;

public record DataFromUser(
    String name,
    String email
) {

    public DataFromUser(User user) {
       this(user.getName(), user.getEmail());
    }
} 
