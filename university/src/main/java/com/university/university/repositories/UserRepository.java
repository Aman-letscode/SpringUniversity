package com.university.university.repositories;

import com.university.university.entities.User;
import org.springframework.data.repository.CrudRepository;


//CrudRepository<object, id_data_type>
public interface UserRepository extends CrudRepository<User,Integer> {
}
