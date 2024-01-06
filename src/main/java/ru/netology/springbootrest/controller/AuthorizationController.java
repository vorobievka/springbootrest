package ru.netology.springbootrest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springbootrest.repository.Authorities;
import ru.netology.springbootrest.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
//      1) AuthorizationService service = new AuthorizationService();
//      2) @Autowired

    private final AuthorizationService service;

    public AuthorizationController() {
        this.service = new AuthorizationService();
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @GetMapping("/hello")
    public String getHello() {
        return "Hello, from Spring Boot App";
    }

    @GetMapping("/")
    public String getStart() {
        return "Hi, you need to go through the authentication process <a href=\"http://localhost:8080/auth\">Authentication</a>";
    }

    @GetMapping("/auth")
    public String getAuthenticationUser() {
        return "Hello, Authenticated user <a href=\"http://localhost:8080/read\">For read</a>  <a href=\"http://localhost:8080/write\">For write</a>";
    }

    @GetMapping("/read")
    public String read() {
        return "Read  <a href=\"http://localhost:8080/write\">For write</a>";
    }

    @GetMapping("/write")
    public String writer() {
        return "Write  <a href=\"http://localhost:8080/read\">For read</a>";
    }
}
