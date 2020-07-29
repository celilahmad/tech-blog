package app.service;

import app.entity.User;
import app.repo.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepo userRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = userRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User saveUser(User user){
        User newUser = new User(user.getUsername(), user.getEmail(), user.getPassword());
       newUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       return userRepo.save(newUser);
    }

    public boolean isRegistered(String email) {
        User byEmail = userRepo.findByEmail(email);
        return byEmail != null && email.equals(byEmail.getUsername());
    }
}
