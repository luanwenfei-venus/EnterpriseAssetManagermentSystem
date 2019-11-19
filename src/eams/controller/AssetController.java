package eams.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import eams.bean.Asset;
import eams.db.AssetRepository;

/**
 * 资产控制类
 * 
 * @author lil
 * @version v1.0
 */
@Controller
@RequestMapping("/admin/asset")
public class AssetController {

	@Autowired
	private AssetRepository assetRepository;

	/**
	 * 进入添加资产
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/register", method = GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute(new Asset());
		return "managerAssetEntryForm";
	}

	/**
	 * 提交资产信息并添加
	 * 
	 * @param asset
	 * @param errors
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/register", method = POST)
	public String processRegistration(@Valid Asset asset, Errors errors) throws ParseException {
		if (errors.hasErrors()) {
			return "managerAssetEntryForm";
		}
		asset = assetRepository.save(asset);
		return "managerHome";
	}
}