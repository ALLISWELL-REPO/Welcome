package com.st.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.st.spring.boot.entity.User;
import com.st.spring.boot.repository.UserRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = 
				SpringApplication.run(Application.class, args);
		
		UserRepository userRepository = 
				context.getBean(UserRepository.class);
		
		// save entities
		/*User user = buildUser();
		userRepository.save(user);*/
		
		// all other methods that we get with repository
		long count = userRepository.count();
		System.out.println("**** count is " + count);
		
		System.out.println(userRepository.findOne(3L));
		
		System.out.println(userRepository.findAll());
		
		userRepository.delete(4L);
		
	}
	
	private static User buildUser() {
		User user = new User();
		user.setFirstName("fname_99");
		user.setLastName("lname_99");
		return user;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
