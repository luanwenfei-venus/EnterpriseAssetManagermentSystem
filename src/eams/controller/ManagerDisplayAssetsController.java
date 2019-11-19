package eams.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eams.bean.Asset;
import eams.bean.Manager;
import eams.db.AssetRepository;

/**
 * 资产显示控制类
 * 
 * @author lil
 * @version v1.0
 */
@Controller
@RequestMapping("/admin/managerDisplayAssets")
public class ManagerDisplayAssetsController {

	@Autowired
	private AssetRepository assetRepository;

	/**
	 * 
	 * @param count
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String assets(Model model,@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		model.addAttribute("paginationSupport",assetRepository.findPage( pageNo, pageSize)); 
		return "managerDisplayAssets";
	}
	
	/**
	 * 归还资产
	 * 
	 * @param managerID
	 * @return
	 */
	@RequestMapping(value = "/{assetId}", method = RequestMethod.GET)
	public String uselog(@PathVariable("assetId") long assetId, HttpSession session) {
		assetRepository.returnAsset(assetId);;
		return "redirect:/admin/managerDisplayAssets";
	}
}
