//package com.university.university.services;
//
//import com.university.university.entities.UserDetails;
//import com.university.university.repositories.DetailRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DetailService {
//
//    @Autowired
//    private DetailRepository details;
//
//    public UserDetails getUserDetails(int Id){
//        UserDetails result=null;
//        try{
//            result =(UserDetails) this.details.findById(Id).stream().findFirst().get();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    public String addDetails(UserDetails details1){
//        UserDetails result= null;
//        try{
//            if(!details1.getEmail().isEmpty() && !details1.getEmail().matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
//                return "Incorrect Email Format";
//            }
//            if(!details1.getPhoneNumber().isEmpty() && !details1.getPhoneNumber().matches("^(\\+\\d{1,3}[-.\\s]?)?\\(?\\d{1,4}\\)?[-.\\s]?\\d{1,9}[-.\\s]?\\d{1,9}$")){
//                return "Incorrect Phone Format";
//            }
//
//
//            result =(UserDetails) this.details.save(details1);
//            if(result==null) {
//                return "Data not able to save";
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//            return "Data Not able to save";
//        }
//        return "Data Successfully saved!!";
//    }
//
//}
