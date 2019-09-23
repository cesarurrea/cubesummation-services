package com.cesurr.domain.model;

import java.util.ArrayList;
import java.util.List;


/** Bean to manage the response for Cube summation process
 * @author Cesar Urrea
 * @author cesarurrea@gmail.com
 * @version 1.0
 * @since 1.0
*/
public class Response {

	private List<String> errorList = new ArrayList<String>();
	private List<Integer> results = new ArrayList<>();

	public Response() {
		super();
	}

	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}

	public List<Integer> getResults() {
		return results;
	}

	public void setResults(List<Integer> results) {
		this.results = results;
	}

}
