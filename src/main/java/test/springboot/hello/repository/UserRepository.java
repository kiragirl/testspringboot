/**
 * @author:liyiming
 * @date:2018年2月26日
 * Description:
 **/
package test.springboot.hello.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import test.springboot.hello.bean.User;

/**
 * Title: UserRepository Description: Company:pusense
 * 
 * @author ：lyiming
 * @date ：2018年2月26日
 **/
public interface UserRepository extends Repository<User, String>{

	Page<User> findAll(Pageable pageable);

	User findUserById(String id);
}
