/**
 * @author:liyiming
 * @date:2018年3月28日
 * Description:
 **/
package test.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import test.springboot.hello.Application;
import test.springboot.hello.spring.CommandManager;
import test.springboot.hello.spring.MethodInjectionTest;

/**
 * Title: MethodInjectionTest Description: Company:pusense
 * 
 * @author ：lyiming
 * @date ：2018年3月28日
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestMethodInjection{

	@Autowired
	private MethodInjectionTest methodInjectionTest;
	@Autowired
	private CommandManager commandManager;
	
	@Test
	public void test(){
		commandManager.getPrototypeBean().say();
		commandManager.getPrototypeBean().say();
		methodInjectionTest.getPrototypeBean().say();
	}
}
