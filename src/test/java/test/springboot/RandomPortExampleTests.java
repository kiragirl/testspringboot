/**
* @author:liyiming
* @date:2018年2月28日
* Description:
**/
package test.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import test.springboot.hello.Application;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 	Title: TestRestTemplate
 *	Description:
 *	Company:pusense
 * 	@author ：lyiming
 * 	@date ：2018年2月28日
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class,webEnvironment = WebEnvironment.RANDOM_PORT)
public class RandomPortExampleTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void exampleTest() {
		String body = this.restTemplate.getForObject("/", String.class);
		assertThat(body).isEqualTo("Hello World");
	}

}