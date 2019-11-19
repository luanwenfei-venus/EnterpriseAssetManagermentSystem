package eams.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eams.db.AssetRepository;

/**
 * @author luanwf
 */
@Controller
@RequestMapping("/userHome")
public class UserHomeController {
	
	@Autowired
	private AssetRepository assetRepository;
	
	@RequestMapping(method = GET)
	public String userHome(Model model) {
		return "userHome";
	}
	
	@RequestMapping(value = "/userAssetList" , method = GET)
	public String assetList(Model model,@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		model.addAttribute("paginationSupport",assetRepository.findPage( pageNo, pageSize));
		return "userAssetList";
	}
}
