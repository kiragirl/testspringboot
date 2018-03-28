/**
* @author:liyiming
* @date:2018年3月28日
* Description:
**/
package test.springboot.hello.spring;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;


/**
 * 	Title: CommandManager
 *	Description:
 *	Company:pusense
 * 	@author ：lyiming
 * 	@date ：2018年3月28日
 **/
@Component
public abstract class CommandManager{
	@Lookup
	public abstract PrototypeBean getPrototypeBean();
}
