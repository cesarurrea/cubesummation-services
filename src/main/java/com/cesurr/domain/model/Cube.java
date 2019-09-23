package com.cesurr.domain.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cube {
	private List<List<List<Integer>>> matrix;
	private Integer size;
	private final Integer DIMENSIONS = 3;

	public Cube() {
		super();
	}

	public void create(Integer size) {
		this.size = size;

		Integer[] init = new Integer[size];

		List<List<List<Integer>>> z = new ArrayList<>(size);

		for (int i = 0; i < size; i++) {
			List<List<Integer>> x = new ArrayList<>(size);
			for (int j = 0; j < size; j++) {
				List<Integer> y = new ArrayList<>(Arrays.asList(init));
				Collections.fill(y, 0);
				x.add(y);
			}
			z.add(x);
		}

		this.matrix = z;

	}

	public List<List<List<Integer>>> getMatrix() {
		return matrix;
	}

	public void setMatrix(List<List<List<Integer>>> matrix) {
		this.matrix = matrix;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getDIMENSIONS() {
		return DIMENSIONS;
	}

	public String toString() {

		String printer = "";

		for (int i = 0; i < getMatrix().size(); i++) {
			for (int j = 0; j < getMatrix().size(); j++) {
				for (int l = 0; l < getMatrix().size(); l++) {
					printer = printer + "[" + getMatrix().get(i).get(j).get(l) + "]";
				}
				printer = printer + "\n";
			}
			printer = printer + "\n";
		}

		return printer;

	}

}
