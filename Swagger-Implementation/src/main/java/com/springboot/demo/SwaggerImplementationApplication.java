package com.springboot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.springboot.demo.entity.Role;
import com.springboot.demo.repository.RoleRepository;

@SpringBootApplication
public class SwaggerImplementationApplication {
	
	@Autowired
	private RoleRepository roleRepo;
	
	public static void main(String[] args){
		SpringApplication.run(SwaggerImplementationApplication.class, args);
		
		
	}
	
	@Component
	class DemoCommandLineRunner implements CommandLineRunner{
		@Override
		public void run(String... args) throws Exception {
			

			
						Role user_role = new Role();
						user_role.setId(1L);
						user_role.setName("ROLE_USER");
						
						Role admin_role = new Role();
						admin_role.setId(2L);
						admin_role.setName("ADMIN");
			
						
							roleRepo.save(user_role);
							roleRepo.save(admin_role);
					

		}
	}
}
