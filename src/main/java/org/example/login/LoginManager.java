package org.example.login;

import java.util.Map;
import java.util.UUID;

public class LoginManager {

    private final Map<String, String> userRepo;


    public LoginManager(Map<String, String> userRepo) {
        this.userRepo = userRepo;
    }

    public Session login(String username, String password){
        if (userRepo.containsKey(username)) {
            if (userRepo.get(username).equals(password)){
                return new Session(username, UUID.randomUUID().toString());
            }
            throw new InvalidCredentialsException("Incorrect Password");
        } else {
            throw new UserNotFoundException(String.format("User with username %s not found", username));
        }
    }
}
