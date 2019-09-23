package com.cesurr.domain.service;

import java.util.ArrayList;
import java.util.List;

import com.cesurr.domain.model.Response;

public class CubeOperations {
	private Integer numberOfTestCases;
	private List<TestCase> testCaseList = new ArrayList<TestCase>();
	private Response response = new Response();

	public Integer getNumberOfTestCases() {
		return numberOfTestCases;
	}

	public void setNumberOfTestCases(Integer numberOfTestCases) {
		this.numberOfTestCases = numberOfTestCases;
	}

	public List<TestCase> getTestCaseList() {
		return testCaseList;
	}

	public void setTestCaseList(List<TestCase> testCaseList) {
		this.testCaseList = testCaseList;
	}
	
	public void addTestCase(TestCase testCase) {
		testCaseList.add(testCase);
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

}
