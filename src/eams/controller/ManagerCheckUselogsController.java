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
import eams.db.UselogRepository;

/**
 * 审批申请控制类
 * 
 * @author lil
 * @version v1.0
 */
@Controller
@RequestMapping("/admin/managerCheckUselogs")
public class ManagerCheckUselogsController {

	@Autowired
	private UselogRepository uselogRepository;

	/**
	 * 申请列表
	 * 
	 * @param count
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String uselogs(Model model,@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		 model.addAttribute("paginationSupport",uselogRepository.findPage(pageNo, pageSize)); 
		  return "managerCheckUselogs";
	}
	
	/**
	 * 审核通过单个申请
	 * 
	 * @param uselogId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{uselogId}", method = RequestMethod.GET)
	public String chkuselog(@PathVariable("uselogId") long uselogId, HttpSession session, Model model) {
		uselogRepository.getUselogChecked(uselogId);
		return "redirect:/admin/managerCheckUselogs";
	}
	
	/**
	 * 拒绝申请 删除申请
	 * 
	 * @param uselogID
	 * @return
	 */	
	@RequestMapping(value = "/delete/{uselogId}", method = RequestMethod.GET)
	public String uselog(@PathVariable("uselogId") long uselogId, HttpSession session) {
		uselogRepository.delete(uselogId);
		return "redirect:/admin/managerCheckUselogs";
	}
}
