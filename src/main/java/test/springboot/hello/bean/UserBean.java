/**
 * @author:liyiming
 * @date:2018年2月12日
 * Description:
 **/
package test.springboot.hello.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 测试外部配置
 * https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config
 * Title: UserBean Description: Company:pusense
 * 
 * @author ：lyiming
 * @date ：2018年2月12日
 **/
@Component
public class UserBean{

	@Value("${name}")
	private String name;
	@Value("${my.secret}")
	private String externalConfigRandomValue;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExternalConfigRandomValue() {
		return externalConfigRandomValue;
	}

	public void setExternalConfigRandomValue(String externalConfigRandomValue) {
		this.externalConfigRandomValue = externalConfigRandomValue;
	}
}
