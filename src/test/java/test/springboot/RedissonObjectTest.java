/**
 * @author:liyiming
 * @date:2018年3月23日
 * Description:
 **/
package test.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import test.springboot.hello.Application;

/**
 * Title: RedissonObjectTest Description: Company:pusense
 * 
 * @author ：lyiming
 * @date ：2018年3月23日
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RedissonObjectTest{

	//private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private RedissonClient redissonClient;

	/**
	 * 同步方法也是调用异步 只是等待异步返回结果 不指定同步也是调用异步
	 * 
	 * @author:liyiming
	 * @date:2018年3月23日
	 * @Description:
	 */
	@Test
	public void RedissonRBucket() {
		RBucket<Integer> bucket = redissonClient.getBucket("int_object_1");
		int a = 10;
		System.out.println(bucket.get());
		// 更新值
		bucket.set(a + 1);
		System.out.println(bucket.get());
		// 如果不存在 设置值
		System.out.println(bucket.trySet(a + 1));
		System.out.println(bucket.get());
		// 比较设置 与期望值一致 则更新
		System.out.println(bucket.compareAndSet(11, 12));
		System.out.println(bucket.get());
		// 更新之后返回旧值
		System.out.println(bucket.getAndSet(13));
		System.out.println(bucket.get());
	}
}
