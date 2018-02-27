/**
 * @author:liyiming
 * @date:2018年2月27日
 * Description:
 **/
package test.springboot;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import test.springboot.hello.Application;
import test.springboot.hello.bean.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * Title: TestRedis Description: Company:pusense
 * 
 * @author ：lyiming
 * @date ：2018年2月27日
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestRedis{

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void test() throws Exception {
		stringRedisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
	}

	@Test
	public void testObj() throws Exception {
		User user = new User("4451323", "aa", "aa123456");
		ValueOperations<String, User> operations = redisTemplate.opsForValue();
		operations.set("com.neox", user);
		operations.set("com.neo.f", user, 1, TimeUnit.SECONDS);
		Thread.sleep(1000);
		// redisTemplate.delete("com.neo.f");
		boolean exists = redisTemplate.hasKey("com.neo.f");
		if (exists) {
			System.out.println("exists is true");
		} else {
			System.out.println("exists is false");
		}
		// Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
	}
}
