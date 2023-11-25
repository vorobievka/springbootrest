package ru.netology.springbootrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springbootrest.repository.Authorities;
import ru.netology.springbootrest.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
//1) AuthorizationService service = new AuthorizationService();
      //2) @Autowired
      @Autowired
      AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
//        System.out.println(user);
//        System.out.println(password);
        return service.getAuthorities(user, password);
    }
}
