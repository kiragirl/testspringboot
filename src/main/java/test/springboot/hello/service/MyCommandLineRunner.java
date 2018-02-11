/**
* @author:liyiming
* @date:2018年2月11日
* Description:
**/
package test.springboot.hello.service;

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

	/**
	 * @author:liyiming
	 * @date:2018年2月11日
	 * @Description:
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
		System.out.println("MyCommandLineRunner is running .....");
		System.out.println(args.toString());
		System.out.println("MyCommandLineRunner is end of run .....");
	}

}
