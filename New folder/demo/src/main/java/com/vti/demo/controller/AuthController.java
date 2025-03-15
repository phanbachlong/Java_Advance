package com.vti.demo.controller;

import java.security.Principal;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.demo.dto.LoginInfoDTO;
import com.vti.demo.entity.Account;
import com.vti.demo.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/auth")
public class AuthController {
    @Autowired
    private IAccountService accountService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/login")
    public LoginInfoDTO login(Principal principal) {
        String userName = principal.getName();

        Account account = accountService.getAccountByUserName(userName);

        LoginInfoDTO loginInfoDTO = modelMapper.map(account, LoginInfoDTO.class);
        System.out.println("Current User: " + SecurityContextHolder.getContext().getAuthentication());

        return loginInfoDTO;
    }
}
