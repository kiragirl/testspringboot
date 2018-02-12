/**
 * @author:liyiming
 * @date:2018年2月12日
 * Description:
 **/
package test.springboot.hello.config;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Title: FooProperties Description: Company:pusense
 * 
 * @author ：lyiming
 * @date ：2018年2月12日
 **/
@Component
@ConfigurationProperties("foo")
public class FooProperties{

	private boolean enabled;

	private InetAddress remoteAddress;

	private final Security security = new Security();


	
	public boolean isEnabled() {
		return enabled;
	}


	
	public InetAddress getRemoteAddress() {
		return remoteAddress;
	}


	
	public Security getSecurity() {
		return security;
	}


	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	
	public void setRemoteAddress(InetAddress remoteAddress) {
		this.remoteAddress = remoteAddress;
	}


	public static class Security{

		private String username;

		private String password;

		private List<String> roles = new ArrayList<>(Collections.singleton("USER"));

		
		public String getUsername() {
			return username;
		}

		
		public String getPassword() {
			return password;
		}

		
		public List<String> getRoles() {
			return roles;
		}

		
		public void setUsername(String username) {
			this.username = username;
		}

		
		public void setPassword(String password) {
			this.password = password;
		}

		
		public void setRoles(List<String> roles) {
			this.roles = roles;
		}

	}
}
