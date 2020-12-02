package com.ProjectEureka.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectEurekaBackendApplication implements CommandLineRunner {

	public static void main(final String[] args) {
		SpringApplication.run(ProjectEurekaBackendApplication.class, args);

	}

	@Autowired
	private UserRepository repository;

	@Override
	public void run(String... args) throws Exception {
		// save a couple of customers

		repository.deleteAll();
		repository.save(new User("David", "Quines"));
		repository.save(new User("Tony", "Tong"));

	}

}
