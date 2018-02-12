/**
* @author:liyiming
* @date:2018年2月11日
* Description:
**/
package test.springboot.hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * 	Title: MyCommandLineRunner
 *	Description:
 *	Company:pusense
 * 	@author ：lyiming
 * 	@date ：2018年2月11日
 **/
@Component
@Order(2)
public class MyCommandLineRunner implements CommandLineRunner{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * @author:liyiming
	 * @date:2018年2月11日
	 * @Description:
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
		logger.info("MyCommandLineRunner is running .....");
	}

}
