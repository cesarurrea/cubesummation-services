package com.cesurr.domain.service;

import com.cesurr.domain.model.Cube;

public class Query implements IGenericOperation {

	private final OperationType operationType = OperationType.QUERY;
	private String operation;
	private Integer result = 0;

	public Query() {
		super();
	}

	@Override
	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public Cube executeOperation(Cube cube) {
		String[] arguments = operation.trim().split("\\s+");

		Integer x1, y1, z1, x2, y2, z2;

		x1 = Integer.valueOf(arguments[1]);
		y1 = Integer.valueOf(arguments[2]);
		z1 = Integer.valueOf(arguments[3]);
		x2 = Integer.valueOf(arguments[4]);
		y2 = Integer.valueOf(arguments[5]);
		z2 = Integer.valueOf(arguments[6]);

		for (int z = (z1 - 1); z <= (z2 - 1); z++) {
			for (int x = (x1 - 1); x <= (x2 - 1); x++) {
				for (int y = (y1 - 1); y <= (y2 - 1); y++) {
					result = result + cube.getMatrix().get(z).get(x).get(y);
				}
			}
		}
		
		return cube;
	}

	@Override
	public Integer getResults() {

		return result;
	}
	
	@Override
	public OperationType getOperationType() {
		return operationType;
	}

}
