package com.cesurr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import org.springframework.http.HttpHeaders;

import org.springframework.test.context.junit4.SpringRunner;

import com.cesurr.domain.service.CubeService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CubesummationServicesApplicationIntTest {

	@Autowired
	CubeService service;

	String plainCommand = "2\n" + "4 5\n" + "UPDATE 2 2 2 4\n" + "QUERY 1 1 1 3 3 3\n" + "UPDATE 1 1 1 23\n"
			+ "QUERY 2 2 2 4 4 4\n" + "QUERY 1 1 1 3 3 3\n" + "2 4\n" + "UPDATE 2 2 2 1\n" + "QUERY 1 1 1 1 1 1\n"
			+ "QUERY 1 1 1 2 2 2\n" + "QUERY 2 2 2 2 2 2";

	@LocalServerPort
	private int port;

	HttpHeaders headers = new HttpHeaders();
	TestRestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void requestOk() {

		Integer statusCode = restTemplate
				.postForEntity(createURLWithPort("/services/procesarCubo"), plainCommand, Void.class)
				.getStatusCodeValue();

		assertEquals(Integer.valueOf(200), statusCode);

	}

	private String createURLWithPort(final String uri) {
		return "http://localhost:" + port + uri;
	}

}
