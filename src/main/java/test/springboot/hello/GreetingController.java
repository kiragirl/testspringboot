/**
 * @author:liyiming
 * @date:2018年2月8日
 * Description:
 **/
package test.springboot.hello;

import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import test.springboot.hello.bean.User;
import test.springboot.hello.bean.UserBean;
import test.springboot.hello.bean.ValidationBean;
import test.springboot.hello.config.FooProperties;
import test.springboot.hello.jms.SendMessage;
import test.springboot.hello.repository.UserRepository;
import test.springboot.hello.service.UserService;
import test.springboot.hello.util.MathUtil;

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
	private UserService userService;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private MathUtil mathUtil;
	@Autowired
	private SendMessage sendMessage;

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
		List<Map<String, Object>> list = jdbcTemplate.queryForList(
				"select username from test_user where test_user.id=?", "141111153857816nrtjl");
		for (Map<String, Object> map : list) {
			logger.debug("the user's username is {}", map.get("username"));
			name = (String) map.get("username");
		}
		// name = userBean.getExternalConfigRandomValue();
		model.addAttribute("name", name);
		return "greeting";
	}

	@RequestMapping("/greeting3")
	public String greeting3(@RequestParam(value = "name", required = false, defaultValue = "kira") String name,Model model) {
		User user = new User();
		user.setUsername(name);
		user.setPassword(name);
		user = userService.saveUser(user);
		user = userService.findUser(user.getId());
		logger.debug(" userRepository.findUserById:{}", user.getUsername());
		/*
		 * System.out.println("Hello \u001b[1;31mred\u001b[0m world!");
		 */
		// String name = userBean.getName();
		String username = properties.getSecurity().getUsername();
		model.addAttribute("name", username);
		return "greeting";
	}

	@RequestMapping("/greeting4")
	public String greeting4(Model model) {
		model.addAttribute("name", mathUtil.computePiDecimal(10));
		try {
			sendMessage.sendMessageByQueue(String.valueOf(mathUtil.computePiDecimal(10)));
			sendMessage.sendMessageByTopic(String.valueOf(mathUtil.computePiDecimal(11)));
		} catch (ConstraintViolationException e) {
			logger.debug(e.getMessage());
			// e.printStackTrace();
		}
		mathUtil.testValidatedSize("weqweqweq");
		return "greeting";
	}
	/**
	 * @Valid 只在此层（@Controller）校验有用 userService中没用
	 * @author:liyiming
	 * @date:2018年2月27日
	 * @Description:
	 * @param user
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping("/greeting5")
	@ResponseBody
	public String greeting5(@RequestBody @Valid ValidationBean user, BindingResult bindingResult,Model model) {
		//处理@Valid异常
		if (bindingResult.hasErrors()) {
			for(FieldError fieldError :bindingResult.getFieldErrors()){
				logger.debug(fieldError.getDefaultMessage());
			};
			return "error";
        }
		userService.saveUser(user);
		return user.getUsername();
	}
	
	@RequestMapping("/valid")
	public String valid(Model model) {
		return "valid";
	}
	
}
