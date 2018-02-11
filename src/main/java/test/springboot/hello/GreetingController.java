/**
 * @author:liyiming
 * @date:2018年2月8日
 * Description:
 **/
package test.springboot.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Title: GreetingController Description: Company:pusense
 * 
 * @author ：lyiming
 * @date ：2018年2月8日
 **/
@Controller
public class GreetingController{
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value="name",required=false,defaultValue="world") String name,Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	@RequestMapping("/greeting2")
	public String greeting2(@RequestParam(value="name",required=false,defaultValue="world") String name,Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
}
