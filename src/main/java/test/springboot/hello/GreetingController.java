/**
 * @author:liyiming
 * @date:2018年2月8日
 * Description:
 **/
package test.springboot.hello;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import test.springboot.hello.bean.User;
import test.springboot.hello.bean.UserBean;
import test.springboot.hello.config.FooProperties;
import test.springboot.hello.repository.UserRepository;

/**
 * Title: GreetingController Description: Company:pusense
 * 
 * @author ：lyiming
 * @date ：2018年2月8日
 **/
@Controller
public class GreetingController{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserBean userBean;
	@Autowired
	private FooProperties properties;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "world") String name,
			Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@RequestMapping("/greeting2")
	public String greeting2(Model model) {
		// String name = userBean.getName();
		String name = "";
		List<Map<String, Object>> list = jdbcTemplate.queryForList("select username from test_user where test_user.id=?",
				"141111153857816nrtjl");
		for (Map<String, Object> map : list) {
			logger.debug("the user's username is {}", map.get("username"));
			name = (String) map.get("username");
		}
		//name = userBean.getExternalConfigRandomValue();
		model.addAttribute("name", name);
		return "greeting";
	}

	@RequestMapping("/greeting3")
	public String greeting3(Model model) {
		User user = userRepository.findUserById("123");
		logger.debug(" userRepository.findUserById:{}",user.getUsername());
		System.out.println("Hello \u001b[1;31mred\u001b[0m world!");
		logger.debug("this is a test debug log");
		logger.info("this is a test info log");
		logger.warn("this is a test warn log");
		logger.error("this is a test error log");
		// String name = userBean.getName();
		String name = properties.getSecurity().getUsername();
		model.addAttribute("name", name);
		return "greeting";
	}
}
