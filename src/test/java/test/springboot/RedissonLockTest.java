/**
 * @author:liyiming
 * @date:2018年3月23日
 * Description:
 **/
package test.springboot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redisson.LockTestTask;
import redisson.RedissonConstants.LockConstants;
import test.springboot.hello.Application;

/**
 * Title: RedissonLockTest Description: Company:pusense
 * 
 * @author ：lyiming
 * @date ：2018年3月23日
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RedissonLockTest{

	@Autowired
	private RedissonClient redissonClient;

	@Test
	public void testRedissonLockTest() {
		int i = 0;
		while (i < 20) {
			ExecutorService executorService = Executors.newCachedThreadPool();
			LockTestTask task = new LockTestTask(LockConstants.TEST_REENTRANT_LOCK, redissonClient);
			executorService.submit(task);
			i++;
		}
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
