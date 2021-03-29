package com.ProjectEureka.backend;

import com.ProjectEureka.backend.services.VideoCallService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectEurekaBackendApplication implements CommandLineRunner {
	public static void main(final String[] args) {

		SpringApplication.run(ProjectEurekaBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//VideoCallService.testAgoraToken();
	}

}
