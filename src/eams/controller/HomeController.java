package eams.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eams.bean.User;
import eams.db.UserRepository;

/**
 * 用户主页控制类
 * 
 * @author lil
 * @version v1.0
 */
@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private UserRepository userRepository;

	/**
	 * 首页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = GET)
	public String home(Model model) {
		return "home";
	}

	/**
	 * 注册
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = GET)
	public String showLoginForm() {
		return "loginForm";
	}

	/**
	 * 登录请求
	 * 
	 * @param userName
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login", method = POST)
	public String processLogin(@RequestParam(value = "userName", defaultValue = "") String userName,
			@RequestParam(value = "password", defaultValue = "") String password, HttpSession session) {
		User user = userRepository.findByUserName(userName, password);
		if (user != null) {
			session.setAttribute("user", user);
			return "redirect:/userHome";
		} else {
			return "loginError";
		}

	}

	/**
	 * 注销
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logout", method = GET)
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		session.invalidate();
		return "redirect:/";
	}
}
