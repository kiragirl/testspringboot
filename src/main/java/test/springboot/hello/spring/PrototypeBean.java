/**
* @author:liyiming
* @date:2018年3月28日
* Description:
**/
package test.springboot.hello.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * 	Title: PrototypeBean
 *	Description:
 *	Company:pusense
 * 	@author ：lyiming
 * 	@date ：2018年3月28日
 **/
@Component("prototypeBean")
@Scope("prototype")
public class PrototypeBean{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	public void say(){
		logger.debug(String.valueOf(this.hashCode()));
	}
}
