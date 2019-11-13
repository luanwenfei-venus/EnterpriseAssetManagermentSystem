package eams.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eams.*;
import eams.bean.Manager;
import eams.db.ManagerRepository;

/**
 * @author luanwf
 */
@Controller // 控制定义
@RequestMapping("/") // 相应web路径
public class HomeController {

	@Autowired // 自动注入资源
	private ManagerRepository managerRepository;

	/**
	 * 首页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = GET) // 相应的请求方法
	public String home(Model model) {
		/*
		 * 依据WebConfig.viewResolver中的
		 * org.springframework.web.servlet.view.InternalResourceViewResolver定义
		 * 
		 * InternalResourceViewResolver resolver = new
		 * InternalResourceViewResolver();
		 * resolver.setPrefix("/WEB-INF/views/"); 
		 * resolver.setSuffix(".jsp");
		 * 
		 * 返回相应jsp视图，即返回/WEB-INF/views/home.jsp
		 * 
		 */
		Manager manager  = new Manager("userName", "password");
		System.out.println("开始存储");
		managerRepository.save(manager);
		System.out.println("OK");
		return "home";
	}
}
