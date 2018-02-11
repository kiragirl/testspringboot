/**
 * @author:liyiming
 * @date:2018年2月8日
 * Description:
 **/
package test.springboot.hello;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Title: Application Description: Company:pusense
 * 
 * @author ：lyiming
 * @date ：2018年2月8日
 **/
//same as @Configuration @EnableAutoConfiguration @ComponentScan
@SpringBootApplication
public class Application{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public ExitCodeGenerator exitCodeGenerator() {
		return new ExitCodeGenerator() {
			@Override
			public int getExitCode() {
				return 42;
			}
		};
	}
}
