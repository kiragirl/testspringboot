/**
 * @author:liyiming
 * @date:2018年3月23日
 * Description:
 **/
package redisson;

import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Title: LockTestTask Description: Company:pusense
 * 
 * @author ：lyiming
 * @date ：2018年3月23日
 **/
public class LockTestTask implements Runnable{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private String id;

	private RedissonClient client;

	public LockTestTask(String id, RedissonClient client) {
		this.id = id;
		this.client = client;
	}

	@Override
	public void run() {
		RLock rLock = client.getLock(id);
		rLock.lock();
		try {
			RedissonRBucket();
		} finally {
			rLock.unlock();
		}
	}

	// @Override
	public void run2() {
		try {
			RedissonRBucket();
		} finally {
		}
	}

	/**
	 * 同步方法也是调用异步 只是等待异步返回结果 不指定同步也是调用异步
	 * 
	 * @author:liyiming
	 * @date:2018年3月23日
	 * @Description:
	 */
	public void RedissonRBucket() {
		RBucket<Integer> bucket = client.getBucket("int_object_1");
		int a = bucket.get();
		// 更新值
		bucket.set(a + 1);
		System.out.println(a + 1);
		// 比较设置 与期望值一致 则更新
		// bucket.compareAndSet(a, a+1);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RedissonClient getClient() {
		return client;
	}

	public void setClient(RedissonClient client) {
		this.client = client;
	}
}
