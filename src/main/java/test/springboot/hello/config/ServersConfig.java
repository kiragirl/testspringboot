/**
 * @author:liyiming
 * @date:2018年2月12日
 * Description:
 **/
package test.springboot.hello.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Title: Config Description: Company:pusense
 * 
 * @author ：lyiming
 * @date ：2018年2月12日
 **/
@ConfigurationProperties(prefix="my")
public class ServersConfig{

	private List<String> servers = new ArrayList<String>();

	public List<String> getServers() {
		return this.servers;
	}
}
