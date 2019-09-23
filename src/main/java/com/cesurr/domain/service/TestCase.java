package com.cesurr.domain.service;

import java.util.ArrayList;
import java.util.List;

import com.cesurr.domain.model.Cube;

/** To manage a testCase
 * @author Cesar Urrea
 * @author cesarurrea@gmail.com
 * @version 1.0
 * @since 1.0
*/
public class TestCase {
	private Cube cube;
	private Integer numOfOperations;
	private List<IGenericOperation> operationList = new ArrayList<IGenericOperation>();
	private List<Integer> resultsList = new ArrayList<>();

	public Cube getCube() {
		return cube;
	}

	public void addOperation(IGenericOperation operation) {
		operationList.add(operation);
	}

	public void setCube(Cube cube) {
		this.cube = cube;
	}

	public List<IGenericOperation> getOperationList() {
		return operationList;
	}

	public void setOperationList(List<IGenericOperation> operationList) {
		this.operationList = operationList;
	}

	public Integer getNumOfOperations() {
		return numOfOperations;
	}

	public void setNumOfOperations(Integer numOfOperations) {
		this.numOfOperations = numOfOperations;
	}

	public List<Integer> processTestCase() {

		for (int i = 0; i < operationList.size(); i++) {
			this.cube = operationList.get(i).executeOperation(cube);

			if (operationList.get(i).getOperationType() == OperationType.QUERY) {
				resultsList.add(operationList.get(i).getResults());
			}
		}

		return resultsList;
	}

}
