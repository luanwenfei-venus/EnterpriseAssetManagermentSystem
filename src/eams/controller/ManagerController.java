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

import eams.bean.Manager;
import eams.db.ManagerRepository;

/**
 * 管理员控制类
 * 
 * @author lil
 * @version v1.0
 */
@Controller
@SessionAttributes({ "manager" })
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private ManagerRepository managerRepository;

	/**
	 * 进入注册
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/register", method = GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute(new Manager());
		return "managerRegisterForm";
	}

	/**
	 * 提交注册信息
	 * 
	 * @param manager
	 * @param errors
	 * @return
	 */
	@RequestMapping(value = "/register", method = POST)
	public String processRegistration(@Valid Manager manager, Errors errors, HttpSession session) {
		if (errors.hasErrors()) {
			return "managerRegisterForm";
		}
		manager = managerRepository.save(manager);
		return "redirect:/manager/" + manager.getUserName();
	}

	/**
	 * 
	 * 
	 * @param managerName
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{managerName}", method = GET)
	public String showManagerProfile(@PathVariable String managerName, Model model) {
		Manager manager = managerRepository.findByUserName(managerName);
		if (manager != null) {
			model.addAttribute(manager);
		}
		return "redirect:/admin";
	}

}
