package com.university.university.controllers;

import com.university.university.entities.User;
import com.university.university.entities.UserDetails;
import com.university.university.services.DetailService;
import com.university.university.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {



    @Autowired
    private UserService userService;

    @Autowired
    private DetailService detailService;

    @GetMapping("/login")
    public ResponseEntity<ModelMap> login(){
        ModelMap model = new ModelMap();
        model.addAttribute("message", new String("You are at login page"));
        return ResponseEntity.of(Optional.of(model));
    }

    @GetMapping("/details")
    public ResponseEntity<ModelMap> details(){
        ModelMap model = new ModelMap();
        model.addAttribute("message","Details are active");
        return ResponseEntity.ok(model);

    }

    @PostMapping("/getdetails")
    public ResponseEntity<ModelMap> getDetails(@RequestBody User user){
        ModelMap model = new ModelMap();
        if(user.getEmailId().isEmpty()){
            model.addAttribute("message","Email not available");
        }else{
            UserDetails result = this.detailService.getUserDetails(user);
            model.addAttribute("messages","success");
            model.addAttribute("details",result);
        }
        return ResponseEntity.ok(model);
    }
    @PostMapping("/adddetails")
    public ResponseEntity<ModelMap> addDetails(@RequestBody UserDetails details){
        ModelMap model = new ModelMap();
        if(details.getEmail().isEmpty()){
            model.addAttribute("message","Email not available");
        }else{
            String result = this.detailService.addDetails(details);
            model.addAttribute("status",result);
//            model.addAttribute("details",result);
        }
        return ResponseEntity.ok(model);
    }


    @PostMapping("/login")
    public ResponseEntity<ModelMap> loginUser(@RequestBody User user,Model model){
        model.addAttribute("user",user);
        String str = model.toString();
        System.out.println(str);
        User result = this.userService.checkUser(user);
        ModelMap response = new ModelMap();
        if(result==null){
            response.addAttribute("error-message","User Not Found");
//            return ResponseEntity.of(Optional.of());
        }
        else {
            response.addAttribute("error-message","User Not Found");
            response.addAttribute("user",result);
        }
        return ResponseEntity.of(Optional.of(response));

    }



    @GetMapping("/register")
    public ResponseEntity<ModelMap> register(){
        ModelMap model = new ModelMap();
        model.addAttribute("message", new String("You are at register page"));
        return ResponseEntity.of(Optional.of(model));
    }

    @PostMapping("/register")
    public ResponseEntity<ModelMap> registerUser(@RequestBody User user){
        ModelMap model=new ModelMap();
//User user =(User) model.asMap().get("user");
        System.out.println(user.equals(null));
        user = this.userService.registerUser(user);
        if(user==null){
            model.addAttribute("error",new String("User Not able to save. Please try again."));

        }else model.addAttribute("message", "successfully Saved.");
        return ResponseEntity.of(Optional.of((ModelMap) model));
    }



}
