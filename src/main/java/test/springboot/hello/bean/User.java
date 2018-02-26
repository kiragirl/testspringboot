/**
 * @author:liyiming
 * @date:2018年2月26日
 * Description:
 **/
package test.springboot.hello.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Title: User Description: Company:pusense
 * 
 * @author ：lyiming
 * @date ：2018年2月26日
 **/
@Entity(name = "test_user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2621515615943111318L;
	@Id
	@GeneratedValue
	private String id;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
