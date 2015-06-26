package com.zhl.business.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhl.business.constant.Url;
import com.zhl.business.constant.View;
import com.zhl.business.model.Community;
import com.zhl.business.service.CommunityService;

@Controller
public class ShopController {
	@Autowired
	private CommunityService communityService;

	@RequestMapping(value = Url.SHOP_INDEX)
	public String index() {
		return View.ShopIndexView;
	}

	@RequestMapping(value = Url.SHOP_DETAIL)
	public String detail() {
		return View.ShopDetailView;
	}
	
	/**
	 * 添加商铺
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.SHOP_ADD)
	public String addShop(ModelMap model){
		List<Community> commList = new LinkedList<Community>();
		commList = communityService.queryCommunity();
		Map<Integer, String> commMap = new HashMap<Integer, String>();
		for (int i = 0; i < commList.size(); i++) {
			commMap.put(commList.get(i).getId(), commList.get(i).getName());
		}
		
		model.addAttribute("commMap", commMap);
		return View.AddShopView;
	}

	/**
	 * 根据小区id获得小区坐标
	 * 
	 * @param cmmId
	 * @param model
	 */
	@ResponseBody
	@RequestMapping(value = Url.SHOP_CMM_LOCATION_GET)
	public Community getCmmLocation(@PathVariable int cmmId, ModelMap model) {
		Community comm = communityService.queryCommunityById(cmmId);
		return comm;
	}

	@RequestMapping(value = Url.SHOP_ADD_SUBMIT, method = RequestMethod.POST)
	public String addShopSubmit(String name, String contacts, String mobile, String endLng, String endLat, int commId) {
		return "";
	}

}
