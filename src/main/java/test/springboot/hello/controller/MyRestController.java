/**
 * @author:liyiming
 * @date:2018年2月12日
 * Description:
 **/
package test.springboot.hello.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.springboot.hello.bean.UserBean;

/**
 * Title: MyRestController Description: Company:pusense
 * 
 * @author ：lyiming
 * @date ：2018年2月12日
 **/
@RestController
@RequestMapping("/users")
public class MyRestController{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserBean userBean;
	@RequestMapping(value = "/{user}", method = RequestMethod.GET)
	public UserBean getUser(@PathVariable Long user) {
		logger.debug(user.toString());
		return userBean;
	}

	@RequestMapping(value = "/{user}/customers", method = RequestMethod.GET)
	List<UserBean> getUserCustomers(@PathVariable Long user) {
		logger.debug(user.toString());
		List<UserBean> list = new ArrayList<UserBean>();
		return list;
	}

	@RequestMapping(value = "/{user}", method = RequestMethod.DELETE)
	public UserBean deleteUser(@PathVariable Long user) {
		logger.debug(user.toString());
		return userBean;
	}
	
	
}
