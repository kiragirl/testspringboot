/**
 * @author:liyiming
 * @date:2018年2月27日
 * Description:
 **/
package test.springboot.hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import test.springboot.hello.bean.User;
import test.springboot.hello.repository.UserRepository;

/**
 * Title: UserService Description: Company:pusense
 * 
 * @author ：lyiming
 * @date ：2018年2月27日
 **/
@Service
public class UserService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserRepository userRepository;

	@Cacheable(value = "user-key")
	public User findUser(String id) {
		User user = userRepository.findUserById(id);
		logger.debug("cache test is ok");
		return user;
	}
}
