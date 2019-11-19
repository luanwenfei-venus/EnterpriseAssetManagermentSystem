package eams.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import eams.bean.Manager;
import eams.db.ManagerRepository;

/**
 * 管理员主页控制类
 * 
 * @author lil
 * @version v1.0
 */
@Controller
@RequestMapping("/admin")
public class ManagerHomeController {

	@Autowired
	private ManagerRepository ManagerRepository;

	/**
	 * 首页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = GET)
	public String home(Model model) {
		return "managerHome";
	}

	/**
	 * 注册
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = GET)
	public String showLoginForm() {
		return "managerLoginForm";
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
		Manager manager = ManagerRepository.findByUserName(userName);
		if (manager != null&&manager.getPassword().equals(password)) {
			session.setAttribute("manager", manager);
			return "redirect:/admin";
		} else {
			return "managerLoginError";
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
		session.removeAttribute("manager");
		session.invalidate();
		return "redirect:/admin";
	}
}
