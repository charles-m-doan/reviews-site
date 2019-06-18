package wcci.reviewssite.integration_tests;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
	@Resource
	private TestRestTemplate restTemplate;
	@LocalServerPort
	private int port;

	// ROOT TESTS

	@Test
	public void greetingShouldReturnHome() {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class),
				containsString("Blighted"));
	}
	
	@Test
	public void greetingShouldReturnHome2() {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/home", String.class),
				containsString("Blighted"));
	}

	// REVIEW TESTS

	// STATIC

	// TEMPLATES

}
