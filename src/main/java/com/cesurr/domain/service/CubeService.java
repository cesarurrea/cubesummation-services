package com.cesurr.domain.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;

import com.cesurr.domain.model.Cube;
import com.cesurr.domain.model.Response;

@Service
public class CubeService {
	

	@Autowired
	private CommandValidator _CommandValidator;

	@Autowired
	private ApplicationContext context;

	public CubeOperations validateInput(String plainCommand) {

		String[] commandList = plainCommand.split("\n");
		Integer numCases = 0;

		CubeOperations cubeOperations = context.getBean(CubeOperations.class);
		Response response = context.getBean(Response.class);

		try {
			numCases = Integer
					.valueOf(_CommandValidator.format(commandList[0], CommandValidator.CommandType.NUMCASES)[0]);

			cubeOperations.setNumberOfTestCases(numCases);

			String[] command;
			int initialPosition = 1;

			for (int i = 0; i < numCases; i++) {
				if (initialPosition < commandList.length) {

					command = _CommandValidator.format(commandList[initialPosition],
							CommandValidator.CommandType.MATRIXPARMS);

					TestCase testCase = context.getBean(TestCase.class);
					Cube cube = context.getBean(Cube.class);

					testCase.setNumOfOperations(Integer.valueOf(command[1]));
					cube.create(Integer.valueOf(command[0]));

					testCase.setCube(cube);

					String[] operationList = Arrays.copyOfRange(commandList, initialPosition + 1,
							(initialPosition + 1) + testCase.getNumOfOperations());

					for (int j = 0; j < operationList.length; j++) {

						command = _CommandValidator.format(operationList[j], CommandValidator.CommandType.OPERATIONS);

						if (command[0].equals(OperationType.UPDATE.toString())) {

							Update update = context.getBean(Update.class);

							update.setOperation(operationList[j]);

							testCase.addOperation(update);

						} else {
							Query query = context.getBean(Query.class);

							query.setOperation(operationList[j]);

							testCase.addOperation(query);

						}

					}

					cubeOperations.addTestCase(testCase);

					initialPosition += testCase.getNumOfOperations() + 1;
				}
			}

		} catch (Exception ex) {
			response.getErrorList().add(ex.getMessage());			
		}
		
		cubeOperations.setResponse(response);

		return cubeOperations;

	}

	public Response executeOperations(CubeOperations cubeOperations) {

		System.out.println("NUMERO DE CASOS DE PRUEBA: " + cubeOperations.getNumberOfTestCases());		
		
		Response response = cubeOperations.getResponse();

		for (int i = 0; i < cubeOperations.getTestCaseList().size(); i++) {
			TestCase testCase = cubeOperations.getTestCaseList().get(i);

			System.out.println("TESTCASE: " + i + " NUMEROOPERACIONES: " + testCase.getNumOfOperations());

			List<Integer> testCaseResults = testCase.processTestCase();
			
			

			for (int j = 0; j < testCaseResults.size(); j++) {
				response.getResults().add(testCaseResults.get(j));
				System.out.println("PROCESADO");
				
			}

		}
		
		cubeOperations.setResponse(response);

		return cubeOperations.getResponse();

	}

}
