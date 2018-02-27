/**
 * @author:liyiming
 * @date:2018年2月27日
 * Description:
 **/
package test.springboot.hello.bean;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Title: ValidationBean Description: Company:pusense
 * 
 * @author ：lyiming
 * @date ：2018年2月27日
 **/
public class ValidationBean{

	@NotEmpty(message = "id不能为空")
	private String id;
	@NotEmpty(message = "password不能为空")
	private String password;
	@NotEmpty(message = "username不能为空")
	private String username;

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
