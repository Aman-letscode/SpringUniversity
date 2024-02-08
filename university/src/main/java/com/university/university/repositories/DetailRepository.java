package com.university.university.repositories;

import com.university.university.entities.UserDetails;
import org.springframework.data.repository.CrudRepository;

public interface DetailRepository extends CrudRepository<UserDetails,Integer> {
    Object findByEmail(String emailId);
}
