package com.university.university.services;

import com.university.university.repositories.UserRepository;
import com.university.university.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepository user;

    public List<User> getAllUsers(){
        List<User> result=null;
        try{

            result =(List<User>) this.user.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public User registerUser(User user1){
        User result= null;
        try{
            result = user.save(user1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public User checkUser(User user1){
        User result = null;
        try {
            result = user.findByEmailIdAndPassword(user1.getEmailId(),user1.getPassword());
            
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

}
