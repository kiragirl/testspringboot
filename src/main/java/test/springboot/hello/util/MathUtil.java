/**
 * @author:liyiming
 * @date:2018年2月27日
 * Description:
 **/
package test.springboot.hello.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Title: MathUtil Description: Company:pusense
 * 
 * @author ：lyiming
 * @date ：2018年2月27日
 **/
@Component
public class MathUtil{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Cacheable("piDecimals")
	public int computePiDecimal(int i) {
		int value = i * 100;
		logger.debug("when i is {},the value is {}", i, value);
		return value;
	}
}
