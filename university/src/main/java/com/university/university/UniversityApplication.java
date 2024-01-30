package com.university.university;

import com.university.university.dao.UserRepository;
import com.university.university.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class UniversityApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(UniversityApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);

//		User user = new User();
//		user.setName("Aman");
//		user.setCity("Pune");
//		user.setCourse("Computer");
//		User user1 = userRepository.save(user);
//		System.out.println(user1);

		userRepository.deleteAll();
		User user1 = new User();
		user1.setName("Aman");
		user1.setCity("Pune");
		user1.setCourse("Computer");

		User user2 = new User();
		user2.setName("Aryan");
		user2.setCity("Nagpur");
		user2.setCourse("Mechanical");

		List<User> users = List.of(user1,user2);
		Iterable<User> result = userRepository.saveAll(users);
		result.forEach(user ->{
			System.out.println(user.getId()+" "+user.getName()+" "+user.getCity()+" "+user.getCourse());
				});
		Optional<User> optional = userRepository.findById(52);
		try {
		User user = optional.get();

		System.out.println(user.getCourse());
		}catch (Exception e){
			throw e;
		}
	}


}
