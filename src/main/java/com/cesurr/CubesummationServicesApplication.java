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

/** SpringBoot java-based Configuration.
 * @author Cesar Urrea
 * @author cesarurrea@gmail.com
 * @version 1.0
 * @since 1.0
*/
@SpringBootApplication
public class CubesummationServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CubesummationServicesApplication.class, args);
	}
	
	/** Bean prototype to Cube Instance Generation.
	 * @param none
	 * 
	*/
	@Bean
	@Scope("prototype")
	public Cube cube() {
		return new Cube();
	}
	
	/** Bean prototype to Update Operation Instance Generation.
	 * @param none
	 * 
	*/

	@Bean
	@Scope("prototype")
	public Update update() {
		return new Update();
	}

	/** Bean prototype to Query Operation Instance Generation.
	 * @param none
	 * 
	*/
	@Bean
	@Scope("prototype")
	public Query query() {
		return new Query();
	}
	
	/** Bean prototype to CubeOperation Instance Generation.
	 * @param none
	 * 
	*/	
	@Bean
	@Scope("prototype")
	public CubeOperations cubeOperations() {
		return new CubeOperations();
	}
	
	/** Bean prototype to TestCase Instance Generation.
	 * @param none
	 * 
	*/	
	@Bean
	@Scope("prototype")
	public TestCase testCase() {
		return new TestCase();
	}
	
	/** Bean prototype to Response Instance Generation.
	 * @param none
	 * 
	*/
	@Bean
	@Scope("prototype")
	public Response response() {
		return new Response();
	}

}
