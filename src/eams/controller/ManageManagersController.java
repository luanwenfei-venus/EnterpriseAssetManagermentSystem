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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eams.bean.Manager;
import eams.db.ManagerRepository;

/**
 * 管理员账户管理控制类
 * 
 * @author lil
 * @version v1.0
 */
@Controller
@RequestMapping("/admin/manageManagers")
public class ManageManagersController {

	@Autowired
	private ManagerRepository managerRepository;

	/**
	 * 
	 * 
	 * @param count
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String managers(Model model, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		model.addAttribute("paginationSupport", managerRepository.findPage(pageNo, pageSize));
		return "manageManagers";
	}

	/**
	 * 注册新管理员
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/register", method = GET)
	public String showRegistrationForm(Model model) {

		// model.addAttribute("manager", new Manager());
		model.addAttribute(new Manager());
		return "managerRegisterForm";
	}

	/**
	 * 注册新管理员
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
		return "redirect:/admin/manageManagers/";
	}

	/**
	 * 删除管理员
	 * 
	 * @param managerID
	 * @return
	 */
	@RequestMapping(value = "/{managerId}", method = RequestMethod.GET)
	public String uselog(@PathVariable("managerId") long managerId, HttpSession session) {
		boolean deleted = false;
		Manager manager = (Manager) session.getAttribute("manager");
		if (manager != null && managerId != manager.getId()) {
			managerRepository.delete(managerId);
			deleted = true;
		}
		return "redirect:/admin/manageManagers/";
	}
}
