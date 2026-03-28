package controller;

import model.User;
import service.AuthService;

public class AuthController {

    private AuthService authService = new AuthService();

    public User login(String email, String password) {
        return authService.login(email, password);
    }

    public boolean register(String name, String email, String password) {
        return authService.register(name, email, password);
    }
}