package com.cesurr;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cesurr.domain.service.CubeOperations;
import com.cesurr.domain.service.CubeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CubesummationServicesApplicationTests {
	
	@Autowired
	CubeService service;
	
	String plainCommand = "2\n" + 
			"4 5\n" + 
			"UPDATE 2 2 2 4\n" + 
			"QUERY 1 1 1 3 3 3\n" + 
			"UPDATE 1 1 1 23\n" + 
			"QUERY 2 2 2 4 4 4\n" + 
			"QUERY 1 1 1 3 3 3\n" + 
			"2 4\n" + 
			"UPDATE 2 2 2 1\n" + 
			"QUERY 1 1 1 1 1 1\n" + 
			"QUERY 1 1 1 2 2 2\n" + 
			"QUERY 2 2 2 2 2 2";

	@Test
	public void numberOfTestCases() {		
		
		CubeOperations cubeOperations = service.validateInput(plainCommand);
		
		assertEquals(Integer.valueOf(2), cubeOperations.getNumberOfTestCases());		
	
	}
	
	@Test
	public void cubeSize() {		
		
		CubeOperations cubeOperations = service.validateInput(plainCommand);		
		
		assertEquals(Integer.valueOf(4), cubeOperations.getTestCaseList().get(0).getCube().getSize());
		assertEquals(Integer.valueOf(2), cubeOperations.getTestCaseList().get(1).getCube().getSize());
		
		
		//List<Integer> results = service.executeOperations(cubeOperations);
		
	}
	
	@Test
	public void numberOfOperations() {		
		
		CubeOperations cubeOperations = service.validateInput(plainCommand);
		
		cubeOperations.getTestCaseList().get(0).getCube().getSize();
		
		assertEquals(Integer.valueOf(5), cubeOperations.getTestCaseList().get(0).getNumOfOperations());
		assertEquals(Integer.valueOf(4), cubeOperations.getTestCaseList().get(1).getNumOfOperations());		
	
		
	}
	
	

}
