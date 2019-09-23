package com.cesurr.domain.application;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesurr.domain.model.Response;
import com.cesurr.domain.service.CubeOperations;
import com.cesurr.domain.service.CubeService;

/** RestController service to mediate frontend with component application.
 * @author Cesar Urrea
 * @author cesarurrea@gmail.com
 * @version 1.0
 * @since 1.0
*/
@RestController
@RequestMapping("services")
public class CubeRestController {
	
	@Autowired
	CubeService service;
	
	/** Start to process new Cube Test Operations from UI
	 * @param String Contains the plain-Command from UI
	 * @return Response Object to contain exceptions and operation results
	*/	
	@PostMapping(value = "/procesarCubo", consumes = MediaType.TEXT_PLAIN_VALUE)
	public Response create(@RequestBody String plainCommand) {
		CubeOperations cubeOperations = service.validateInput(plainCommand);
		
		Response response = service.executeOperations(cubeOperations);
		
		return response;
		
	}

}
