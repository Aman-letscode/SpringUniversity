package com.university.university.controllers;

import com.university.university.dto.LoginDTO;
import com.university.university.dto.ResponseDTO;
import com.university.university.dto.SignUpDTO;
import com.university.university.entities.User;
import com.university.university.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;
import java.util.Optional;


@CrossOrigin
@RestController
public class UserController {



    @Autowired
    private UserService userService;


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

    @GetMapping("/allUsers")
    public ResponseEntity<ModelMap> getDetails(){
        ModelMap model = new ModelMap();
            List<User> result = this.userService.getAllUsers();
            if(result==null){
                model.addAttribute("message","User does not exist.");
            }else{

            model.addAttribute("message","success");
            model.addAttribute("details",result);
            }

        return ResponseEntity.ok(model);
    }
//    @PostMapping("/details")
//    public ResponseEntity<ModelMap> addDetails(@RequestBody UserDetails details){
//        ModelMap model = new ModelMap();
//        if(details.getEmail().isEmpty()){
//            model.addAttribute("message","Email not available");
//        }else{
//            String result = this.detailService.addDetails(details);
//            model.addAttribute("status",result);
////            model.addAttribute("details",result);
//        }
//        return ResponseEntity.ok(model);
//    }




    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO user){

        ResponseDTO response = this.userService.checkUser(user);



        return ResponseEntity.of(Optional.of(response));

    }



    @GetMapping("/register")
    public ResponseEntity<ModelMap> register(){
        ModelMap model = new ModelMap();
        model.addAttribute("message", new String("You are at register page"));
        return ResponseEntity.of(Optional.of(model));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDTO details){
        ModelMap model=new ModelMap();
//User user =(User) model.asMap().get("user");
        System.out.println(details == null);
        ResponseDTO response = this.userService.registerUser(details);

        return ResponseEntity.of(Optional.of(response));
    }



}
