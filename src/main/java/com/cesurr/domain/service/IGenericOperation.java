package com.cesurr.domain.service;

import com.cesurr.domain.model.Cube;

public interface IGenericOperation {
	
	public void setOperation(String operation);
	
	public Cube executeOperation(Cube cube);
	
	public Integer getResults();
	
	public OperationType getOperationType();

}
