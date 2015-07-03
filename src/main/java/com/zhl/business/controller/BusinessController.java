package com.zhl.business.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhl.business.constant.Url;
import com.zhl.business.constant.View;

@Controller
public class BusinessController {
	private static final String BASE_PATH = "http://localhost:8080/baobiao";
	/**
	 * 首页
	 * 
	 * @return
	 */
	@RequestMapping(value = Url.INDEX)
	public String index() {
		return View.IndexView;
	}

	/**
	 * 左页面
	 * 
	 * @return
	 */
	@RequestMapping(value = Url.REPORT_LEFT)
	public String left() {
		return View.ReportLeftView;
	}

	/**
	 * 右页面
	 * 
	 * @return
	 */
	@RequestMapping(value = Url.REPORT_RIGHT)
	public String right() {
		return View.ReportRightView;
	}

	/**
	 * 显示查询中页面
	 * 
	 * @param parm
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.REPORT_SEARCHING)
	public String searching(@PathVariable int parm, ModelMap model) {
		String url = "";
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dt);

		switch(parm){
		case 1: // 院长日报
			url = BASE_PATH + "/report/daily/dean/dateStart/" + date + "/dateEnd/" + date;
			model.addAttribute("url", url);
			break;
		case 2: // 资源配置
			url = BASE_PATH + "/report/resources";
			model.addAttribute("url", url);
			break;
		case 3: // 工作负荷
			url = BASE_PATH + "/report/workload/dateStart/" + date + "/dateEnd/" + date;
			model.addAttribute("url", url);
			break;
		}
		return View.ReportSearchingView;
	}
}

