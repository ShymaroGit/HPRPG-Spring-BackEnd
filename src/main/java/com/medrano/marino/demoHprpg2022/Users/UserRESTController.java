package com.medrano.marino.demoHprpg2022.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/hprpg/users/")
public class UserRESTController {
    private UserService userService;

    @Autowired
    public UserRESTController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<IUserSafe> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "{uuid}")
    public Optional<IUserSafe> getUser(@PathVariable("uuid") String uuid) {
        return userService.getUserByUUIDSafe(uuid);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "login")
    public ResponseEntity<Object> login(@RequestBody UserLogin user) {
        Optional<Users> loginUser = userService.login(user.getUsername(), user.getPassword());

        if(loginUser.isEmpty()){
            return new ResponseEntity<Object>("Compte Introuvable: Mot de passe ou Username inconnu", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Object>(loginUser, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "signin")
    public void createUser(@RequestBody UserSignin user){
        userService.createUser(user);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path = "PassChange/{uuid}")
    public void changePassword(@PathVariable("uuid") String uuid,@RequestBody UserSignin user){
            Optional<Users> foundUser = userService.login(user.getUsername(),user.getPassword());
            if(foundUser.isPresent()){
                userService.updatePassword(uuid,user.getPassword() ,user.getPassword_confirm());
            }
    }
}
