package com.foro.foroAlura.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foro.foroAlura.domain.user.User;
import com.foro.foroAlura.domain.user.UserService;
import com.foro.foroAlura.domain.user.dto.DataAuthUser;
import com.foro.foroAlura.domain.user.dto.DataCreateUser;
import com.foro.foroAlura.domain.user.dto.DataFromUser;
import com.foro.foroAlura.infra.Security.DataTokenJWT;
import com.foro.foroAlura.infra.Security.TokenService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DataFromUser> receiveUser (@RequestBody @Valid DataCreateUser dataCreateUser) {
        User user= userService.saveUser(new User(dataCreateUser));
        return ResponseEntity.ok(new DataFromUser(user));
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/login")
    public  ResponseEntity login (@RequestBody @Valid DataAuthUser dataAuthUser) {

        var token=new UsernamePasswordAuthenticationToken(dataAuthUser.email(), dataAuthUser.password());
        var auth=manager.authenticate(token);
        var tokenJWT=tokenService.generarToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new DataTokenJWT(tokenJWT) );

    }



}
