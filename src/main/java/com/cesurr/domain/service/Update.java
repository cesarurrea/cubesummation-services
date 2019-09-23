package com.cesurr.domain.service;

import com.cesurr.domain.model.Cube;

/** Update Operations
 * @author Cesar Urrea
 * @author cesarurrea@gmail.com
 * @version 1.0
 * @since 1.0
*/
public class Update implements IGenericOperation {

	private final OperationType operationType = OperationType.UPDATE;
	private String operation;

	public Update() {
		super();
	}

	@Override
	public void setOperation(String operation) {
		this.operation = operation;

	}

	@Override
	public Cube executeOperation(Cube cube) {
		String[] arguments = operation.trim().split("\\s+");

		Integer x, y, z, value;

		x = Integer.valueOf(arguments[1]);
		y = Integer.valueOf(arguments[2]);
		z = Integer.valueOf(arguments[3]);
		value = Integer.valueOf(arguments[4]);

		cube.getMatrix().get((z - 1)).get((x - 1)).set((y - 1), value);

		return cube;
	}

	@Override
	public Integer getResults() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperationType getOperationType() {
		return operationType;
	}

}
