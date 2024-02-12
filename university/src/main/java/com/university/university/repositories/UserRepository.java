package com.university.university.repositories;

import com.university.university.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


//CrudRepository<object, id_data_type>
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmailIdAndPassword(String email,String password);
}
