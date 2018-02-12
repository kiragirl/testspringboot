/**
 * @author:liyiming
 * @date:2018年2月11日
 * Description:
 **/
package test.springboot.hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * If you need to run some specific code once the SpringApplication has started,
 * you can implement the ApplicationRunner or CommandLineRunner interfaces. Both
 * interfaces work in the same way and offer a single run method which will be
 * called just before SpringApplication.run(…​) completes.
 * Title: MyApplicationRunner Description: Company:pusense
 * @author ：lyiming
 * @date ：2018年2月11日
 **/
@Component
@Order(3)
public class MyApplicationRunner implements ApplicationRunner{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * @author:liyiming
	 * @date:2018年2月11日
	 * @Description:
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("ApplicationRunner is running .....");
		/*System.out.println(args.getOptionNames().toString());
		System.out.println(args.getNonOptionArgs().toString());
		System.out.println(args.getSourceArgs());*/
	}

}
