package com.ProjectEureka.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ProjectEureka.backend.models.User;
import com.ProjectEureka.backend.repositories.UserRepository;

@SpringBootApplication
public class ProjectEurekaBackendApplication implements CommandLineRunner {

	public static void main(final String[] args) {
		SpringApplication.run(ProjectEurekaBackendApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	}

}
