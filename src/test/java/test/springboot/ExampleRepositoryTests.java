/**
 * @author:liyiming
 * @date:2018年3月1日
 * Description:
 **/
package test.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import test.springboot.hello.Application;
import test.springboot.hello.bean.User;
import test.springboot.hello.repository.UserRepository;
import static org.assertj.core.api.Assertions.*;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
/**
 * Title: ExampleRepositoryTests Description: Company:pusense
 * 
 * @author ：lyiming
 * @date ：2018年3月1日
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ExampleRepositoryTests{

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository repository;

	@Test
	public void testExample() throws Exception {
		this.entityManager.persist(new User("12321321","sboot", "1234"));
		User user = this.repository.findUserById("12321321");
		assertThat(user.getUsername()).isEqualTo("sboot");
		assertThat(user.getPassword()).isEqualTo("1234");
	}
}
