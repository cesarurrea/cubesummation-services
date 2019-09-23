package com.cesurr.domain.service;

import com.cesurr.domain.model.Cube;

/** Generic Interface to implement a new Operation
 * @author Cesar Urrea
 * @author cesarurrea@gmail.com
 * @version 1.0
 * @since 1.0
*/
public interface IGenericOperation {
	
	public void setOperation(String operation);
	
	public Cube executeOperation(Cube cube);
	
	public Integer getResults();
	
	public OperationType getOperationType();

}
