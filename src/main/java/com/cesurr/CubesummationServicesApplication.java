package com.cesurr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.cesurr.domain.model.Cube;
import com.cesurr.domain.model.Response;
import com.cesurr.domain.service.CubeOperations;
import com.cesurr.domain.service.Query;
import com.cesurr.domain.service.TestCase;
import com.cesurr.domain.service.Update;

@SpringBootApplication
public class CubesummationServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CubesummationServicesApplication.class, args);
	}	

	@Bean
	@Scope("prototype")
	public Cube cube() {
		return new Cube();
	}

	@Bean
	@Scope("prototype")
	public Update update() {
		return new Update();
	}

	@Bean
	@Scope("prototype")
	public Query query() {
		return new Query();
	}
	
	@Bean
	@Scope("prototype")
	public CubeOperations cubeOperations() {
		return new CubeOperations();
	}
	
	@Bean
	@Scope("prototype")
	public TestCase testCase() {
		return new TestCase();
	}
	
	@Bean
	@Scope("prototype")
	public Response response() {
		return new Response();
	}

}
