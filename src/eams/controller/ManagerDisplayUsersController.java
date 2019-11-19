package eams.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eams.bean.Manager;
import eams.db.UserRepository;

/**
 * 吐槽者显示控制类
 * 
 * @author lil
 * @version v1.0
 */
@Controller
@RequestMapping("/admin/managerDisplayUsers")
public class ManagerDisplayUsersController {

	@Autowired
	private UserRepository userRepository;

	/**
	 * 
	 * @param count
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String users(Model model,@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		model.addAttribute("paginationSupport",userRepository.findPage( pageNo, pageSize)); 
		return "managerDisplayUsers";
	}
	
	/**
	 * 删除用户
	 * 
	 * @param userID
	 * @return
	 */	
	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
	public String uselog(@PathVariable("userId") long userId, HttpSession session) {
		userRepository.delete(userId);
		return "redirect:/admin/managerDisplayUsers/";
	}
	
	/**
	 * 锁定用户
	 * 
	 * @param userID
	 * @return
	 */	
	@RequestMapping(value = "/lock/{userId}", method = RequestMethod.GET)
	public String lock(@PathVariable("userId") long userId, HttpSession session) {
		userRepository.lock(userId);
		return "redirect:/admin/managerDisplayUsers/";
	}
	
	/**
	 * 解锁用户
	 * 
	 * @param userID
	 * @return
	 */	
	@RequestMapping(value = "/unlock/{userId}", method = RequestMethod.GET)
	public String unlock(@PathVariable("userId") long userId, HttpSession session) {
		userRepository.unlock(userId);
		return "redirect:/admin/managerDisplayUsers/";
	}
}
