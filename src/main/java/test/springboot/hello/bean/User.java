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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

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
	//使用数据库自增列
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(generator = "snowFlakeId")
	@GenericGenerator(name = "snowFlakeId", strategy = "test.springboot.hello.util.SnowflakeId")
	private String id;
	
	@Column(nullable = false)
	@NotEmpty(message = "username不能为空")
	private String username;
	
	@Column(nullable = false)
	@NotEmpty(message = "password不能为空")
	private String password;

	public User() {
	}

	public User(String id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

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
