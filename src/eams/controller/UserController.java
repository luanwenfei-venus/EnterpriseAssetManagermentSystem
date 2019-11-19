package eams.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import eams.bean.User;
import eams.db.UserRepository;

/**
 * 用户控制类
 * 
 * @author lil
 * @version v1.0
 */
@Controller
@SessionAttributes({ "user" })
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	/**
	 * 进入注册
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/register", method = GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute(new User());
		return "registerForm";
	}

	/**
	 * 提交注册信息
	 * 
	 * @param user
	 * @param errors
	 * @return
	 */
	@RequestMapping(value = "/register", method = POST)
	public String processRegistration(@Valid User user, Errors errors, HttpSession session) {
		if (errors.hasErrors()) {
			return "registerForm";
		}
		user = userRepository.save(user);
		if (user != null) {
			session.setAttribute("user", user);
		}
		return "redirect:/";
	}
}