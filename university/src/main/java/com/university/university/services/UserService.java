package com.university.university.services;

import com.university.university.dto.LoginDTO;
import com.university.university.dto.ResponseDTO;
import com.university.university.dto.SignUpDTO;
import com.university.university.repositories.UserRepository;
import com.university.university.entities.User;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepository user;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers(){
        List<User> result=null;
        try{

            result =(List<User>) this.user.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public ResponseDTO registerUser(SignUpDTO user1){

        System.out.println(user1.toString());
        try{
            User allreadypresent = user.findByEmail(user1.getEmail());
            if(allreadypresent!=null){
                return new ResponseDTO("failed","user already exist","");
            }
            User new_user = user.save(new User(user1.getName(),user1.getEmail(),passwordEncoder.encode(user1.getPassword()),user1.getRole(), user1.getPhonenumber()));
            if(new_user==null){
                return new ResponseDTO("failed","user not able to save","No token generated");
            }
            return new ResponseDTO("success","User created Successfully", user1.getRole());
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseDTO("failed","Error occurred","No token generated");
    }

    public ResponseDTO checkUser(LoginDTO user1){
        System.out.println(user1.toString());
        ResponseDTO response = null;
        User result = null;
        try {
            result = user.findByEmail(user1.getEmail());
            if(result==null) return new ResponseDTO("failed","No user email found","No token generated");
            System.out.println(passwordEncoder.encode(user1.getPassword()));
            boolean passwordMatches = passwordEncoder.matches(user1.getPassword(), result.getPassword());
            if(!passwordMatches){
                return new ResponseDTO("failed","password does not match","No token generated");
            }
            return new ResponseDTO("success","user successfully logged in",result.getRole());
            
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseDTO("failed","Error Detected","");
    }

}
