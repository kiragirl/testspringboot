/**
 * @author:liyiming
 * @date:2018年2月27日
 * Description:
 **/
package test.springboot.hello.util;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * Title: MathUtil Description: Company:pusense
 * 
 * @author ：lyiming
 * @date ：2018年2月27日
 **/
@Component
@Validated
public class MathUtil{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * @DecimalMax message不在异常中显示  不知道为什么
	 * @author:liyiming
	 * @date:2018年2月27日
	 * @Description:
	 * @param i
	 * @return
	 */
	@Cacheable("piDecimals")
	public int computePiDecimal(@DecimalMax(value="10",message="输入参数校验失败") int i) {
		int value = i * 100;
		logger.debug("when i is {},the value is {}", i, value);
		return value;
	}
	
	public void testValidatedSize(@Size(min = 8, max = 10,message="wqeqe") String code){
		logger.debug("the String code is {}",code);
	}
}
