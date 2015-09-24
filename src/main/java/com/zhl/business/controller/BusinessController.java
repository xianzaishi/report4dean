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
		case 4: // 治疗质量
			url = BASE_PATH + "/report/workQuality/dateStart/" + date + "/dateEnd/" + date;
			model.addAttribute("url", url);
			break;
		case 5: // 工作效率
			url = BASE_PATH + "/report/workEfficiency/dateStart/" + date + "/dateEnd/" + date;
			model.addAttribute("url", url);
			break;
		case 6: // 患者负担
			url = BASE_PATH + "/report/patientCost/dateStart/" + date + "/dateEnd/" + date;
			model.addAttribute("url", url);
			break;
		case 7: // 资产运营
			url = BASE_PATH + "/report/assetsOperation/dateStart/" + date + "/dateEnd/" + date;
			model.addAttribute("url", url);
			break;
		case 9: // 按抢救成功率分析
			url = BASE_PATH + "/report/rescueSuccessRate/dateStart/" + date + "/dateEnd/" + date;
			model.addAttribute("url", url);
			break;
		case 10: // 患者平均住院天数分析
			url = BASE_PATH + "/report/dayOfPatientCost/dateStart/" + date + "/dateEnd/" + date;
			model.addAttribute("url", url);
			break;
		case 11: // 平均病床工作日
			url = BASE_PATH + "/report/avgWorkingBeds/dateStart/" + date + "/dateEnd/" + date;
			model.addAttribute("url", url);
			break;
		case 12: // 病床周转次数分析
			url = BASE_PATH + "/report/bedTurnoverTimes/dateStart/" + date + "/dateEnd/" + date;
			model.addAttribute("url", url);
			break;
		case 13: // 门诊诊断符合率
			url = BASE_PATH + "/report/opDiagnosticRate/dateStart/" + date + "/dateEnd/" + date;
			model.addAttribute("url", url);
			break;
		case 14: // 全院临床病理符合率
			url = BASE_PATH + "/report/pathologicalRate/dateStart/" + date + "/dateEnd/" + date;
			model.addAttribute("url", url);
			break;
		case 15: // 大型设备阳性率
			url = BASE_PATH + "/report/equipmentPositiveRate/dateStart/" + date + "/dateEnd/" + date;
			model.addAttribute("url", url);
			break;
		case 16: // 好转率
			url = BASE_PATH + "/report/improvementRate/dateStart/" + date + "/dateEnd/" + date;
			model.addAttribute("url", url);
			break;
		case 17: // 治愈率
			url = BASE_PATH + "/report/cureRate/dateStart/" + date + "/dateEnd/" + date;
			model.addAttribute("url", url);
			break;
		case 18: // 死亡率
			url = BASE_PATH + "/report/deathRate/dateStart/" + date + "/dateEnd/" + date;
			model.addAttribute("url", url);
			break;
		case 19: // 在院病人分布
			url = BASE_PATH + "/report/ipSpread/dateStart/" + date + "/dateEnd/" + date;
			model.addAttribute("url", url);
			break;
		}
		return View.ReportSearchingView;
	}
}

