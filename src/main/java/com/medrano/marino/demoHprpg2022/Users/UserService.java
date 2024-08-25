package com.medrano.marino.demoHprpg2022.Users;

import com.medrano.marino.demoHprpg2022.Debugger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    public final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<IUserSafe> getUsers() {
        return userRepository.getUsers();
    }

    public Optional<IUserSafe> getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    public Optional<IUserSafe> getUserByUUIDSafe(String uuid) {
        return userRepository.getUserByUUIDSafe(uuid);
    }
    public Optional<Users> getUserByUUIDFull(String uuid) {
        return userRepository.getUserByUUIDFull(uuid);
    }
    public Optional<Users> login(String username, String password) {
        BCryptPasswordEncoder passwordEcorder = new BCryptPasswordEncoder();
        String SafePassword = HtmlUtils.htmlEscape(password);
        Optional<Users> user = userRepository.Login(HtmlUtils.htmlEscape(username));

        if(Debugger.isEnabled()) {
            Debugger.log(password);
            Debugger.log(user);
        }

        if (user.isPresent()) {
            if(Debugger.isEnabled())
                Debugger.log(user);
            Boolean passMatch = passwordEcorder.matches(SafePassword,user.get().getPassword());
            if(Debugger.isEnabled())
                Debugger.log("Result:" + passMatch);

            user.get().emptyPassword();

            if(!passMatch){
                user = Optional.empty();
            }

        }
        return user;
    }

    public void createUser(UserSignin user){
        if(user.isPassConfirmed()){
            if(Debugger.isEnabled())
                Debugger.log("Password match");
            String encodedPassword = Users.hashPassword(user.getPassword());
            Optional<IUserSafe> existUser = userRepository.getUserByUsername(user.getUsername());

            if(existUser.isEmpty()){
                Users newUser = new Users(user.getUsername(),encodedPassword);
                newUser.setUuid(UUID.randomUUID().toString());
                userRepository.save(newUser);
            }
        }else{
            if(Debugger.isEnabled())
                Debugger.log("no match");
        }
;    }

    public void updatePassword(String uuid,String oldPassword, String newPassword){
        userRepository.updatePassword(uuid, newPassword);
    }

}
