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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import test.springboot.hello.Application;
import test.springboot.hello.service.UserService;
import test.springboot.hello.util.MathUtil;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

/**
 * Title: MockBeanTest Description: Company:pusense
 * 
 * @author ：lyiming
 * @date ：2018年2月28日
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MockBeanTest{

	@MockBean
	private MathUtil mathUtil;

	@Autowired
	private UserService userService;

	@Test
	public void exampleTest() {
		// RemoteService has been injected into the reverser bean
		given(this.mathUtil.computePiDecimal(5)).willReturn(10);
		String reverse = userService.findUser("123").getUsername();
		assertThat(reverse).isEqualTo("kira");
	}
}
