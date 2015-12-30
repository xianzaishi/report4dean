package com.zhl.business.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhl.business.constant.Url;
import com.zhl.business.constant.View;

@Controller
public class BusinessController {
	private static final String BASE_PATH = "http://localhost:8080/baobiao"; // 172.16.0.202
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
		// 当天时间
		String date = sdf.format(dt);

		// 上个月时间段
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		month = month - 1;
		int day = getDayOfMonth(month);
		String filterDateOfMonthStart = year + "-" + month + "-01";
		String filterDateOfMonthEnd = year + "-" + month + "-" + day;

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
			url = BASE_PATH + "/report/workQuality/dateStart/" + filterDateOfMonthStart + "/dateEnd/" + filterDateOfMonthEnd;
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
			url = BASE_PATH + "/report/rescueSuccessRate/dateStart/" + filterDateOfMonthStart + "/dateEnd/" + filterDateOfMonthEnd;
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
		case 14: // 全院临床病理符合率 按月
			url = BASE_PATH + "/report/pathologicalRate/dateStart/" + date + "/dateEnd/" + date;
			model.addAttribute("url", url);
			break;
		case 15: // 大型设备阳性率
			url = BASE_PATH + "/report/equipmentPositiveRate/dateStart/" + date + "/dateEnd/" + date;
			model.addAttribute("url", url);
			break;
		case 16: // 好转率 按月
			url = BASE_PATH + "/report/improvementRateByMonth/dateStart/" + date + "/dateEnd/" + date;
			model.addAttribute("url", url);
			break;
		case 17: // 治愈率 按月
			url = BASE_PATH + "/report/cureRateByMonth/dateStart/" + date + "/dateEnd/" + date;
			model.addAttribute("url", url);
			break;
		case 18: // 死亡率 按月
			url = BASE_PATH + "/report/deathRateByMonth/dateStart/" + date + "/dateEnd/" + date;
			model.addAttribute("url", url);
			break;
		case 19: // 在院病人分布
			url = BASE_PATH + "/report/ipSpread/dateStart/" + date + "/dateEnd/" + date;
			model.addAttribute("url", url);
			break;
		case 23: // 好转率 按科室
			url = BASE_PATH + "/report/improvementRateByDept/dateStart/" + filterDateOfMonthStart + "/dateEnd/" + filterDateOfMonthEnd;
			model.addAttribute("url", url);
			break;
		case 24: // 治愈率 按科室
			url = BASE_PATH + "/report/cureRateByDept/dateStart/" + filterDateOfMonthStart + "/dateEnd/" + filterDateOfMonthEnd;
			model.addAttribute("url", url);
			break;
		case 25: // 死亡率 按科室
			url = BASE_PATH + "/report/deathRateByDept/dateStart/" + filterDateOfMonthStart + "/dateEnd/" + filterDateOfMonthEnd;
			model.addAttribute("url", url);
			break;
		case 27: // 病床周转次数 按科室
			url = BASE_PATH + "/report/bedTurnoverTimesByDept/dateStart/" + filterDateOfMonthStart + "/dateEnd/" + filterDateOfMonthEnd;
			model.addAttribute("url", url);
			break;
		case 28: // 全院临床病理符合率 按科室
			url = BASE_PATH + "/report/pathologicalRateByDept/dateStart/" + filterDateOfMonthStart + "/dateEnd/" + filterDateOfMonthEnd;
			model.addAttribute("url", url);
			break;
		case 33: // 平均病床工作日 按科室
			url = BASE_PATH + "/report/avgWorkingBedsByDept/dateStart/" + filterDateOfMonthStart + "/dateEnd/" + filterDateOfMonthEnd;
			model.addAttribute("url", url);
			break;
		case 36: // 手术明细表 愈合 甲
			url = BASE_PATH + "/report/operationDetailFirst/dateStart/" + filterDateOfMonthStart + "/dateEnd/" + filterDateOfMonthEnd;
			model.addAttribute("url", url);
			break;
		case 37: // 手术明细表 愈合 乙
			url = BASE_PATH + "/report/operationDetailSecond/dateStart/" + filterDateOfMonthStart + "/dateEnd/" + filterDateOfMonthEnd;
			model.addAttribute("url", url);
			break;
		case 38: // 手术明细表 愈合 丙
			url = BASE_PATH + "/report/operationDetailThird/dateStart/" + filterDateOfMonthStart + "/dateEnd/" + filterDateOfMonthEnd;
			model.addAttribute("url", url);
			break;
		case 39: // 手术明细表 愈合 丁
			url = BASE_PATH + "/report/operationDetailForth/dateStart/" + filterDateOfMonthStart + "/dateEnd/" + filterDateOfMonthEnd;
			model.addAttribute("url", url);
			break;
		case 41: // 分科病人手术操作质量
			url = BASE_PATH + "/report/operationQualityByDept/dateStart/" + filterDateOfMonthStart + "/dateEnd/" + filterDateOfMonthEnd;
			model.addAttribute("url", url);
			break;
		case 42: // 分科病人手术操作质量 外科系统
			url = BASE_PATH + "/report/operationQualityByDeptWaiKe/dateStart/" + filterDateOfMonthStart + "/dateEnd/" + filterDateOfMonthEnd;
			model.addAttribute("url", url);
			break;
		case 43: // 分科病人手术操作质量 内科系统
			url = BASE_PATH + "/report/operationQualityByDeptNeiKe/dateStart/" + filterDateOfMonthStart + "/dateEnd/" + filterDateOfMonthEnd;
			model.addAttribute("url", url);
			break;
		case 44: // 入出院诊断符合率
			url = BASE_PATH + "/report/diagnosticRate/dateStart/" + filterDateOfMonthStart + "/dateEnd/" + filterDateOfMonthEnd;
			model.addAttribute("url", url);
			break;
		case 45: // 手术前后诊断符合率
			url = BASE_PATH + "/report/operationDiagnosticRate/dateStart/" + filterDateOfMonthStart + "/dateEnd/" + filterDateOfMonthEnd;
			model.addAttribute("url", url);
			break;
		case 46: // 临床主要诊断与病理诊断符合率
			url = BASE_PATH + "/report/bingLiZhenDuanRate/dateStart/" + filterDateOfMonthStart + "/dateEnd/" + filterDateOfMonthEnd;
			model.addAttribute("url", url);
			break;
		case 47: // 重点手术疗效及费用(ICD)18以上
			url = BASE_PATH + "/report/zhongDianShouShuLiaoXiao/dateStart/" + filterDateOfMonthStart + "/dateEnd/" + filterDateOfMonthEnd;
			model.addAttribute("url", url);
			break;
		case 49: // 重点疾病疗效及费用(ICD)18以上
			url = BASE_PATH + "/report/zhongDianJiBingLiaoXiao/dateStart/" + filterDateOfMonthStart + "/dateEnd/" + filterDateOfMonthEnd;
			model.addAttribute("url", url);
			break;
		case 50: // 重点疾病疗效及费用(ICD)18以上 卫生部
			url = BASE_PATH + "/report/zhongDianJiBingLiaoXiaoWeiShengBu/dateStart/" + filterDateOfMonthStart + "/dateEnd/" + filterDateOfMonthEnd;
			model.addAttribute("url", url);
			break;
		case 52: // DR甲片率
			url = BASE_PATH + "/report/DRJiaPianLv/dateStart/" + date + "/dateEnd/" + date;
			model.addAttribute("url", url);
			break;
		case 53: // 单病种手术疾病疗效及费用
			url = BASE_PATH + "/report/danBingZhongShouShuJiBingLiaoXiao/dateStart/" + filterDateOfMonthStart + "/dateEnd/" + filterDateOfMonthEnd;
			model.addAttribute("url", url);
			break;
		}
		return View.ReportSearchingView;
	}

	/**
	 * 获得一个月的天数
	 * 
	 * @param month
	 * @return
	 */
	private static int getDayOfMonth(int month) {
		Calendar cal = Calendar.getInstance();
		// 下面可以设置月份，注：月份设置要减1，所以设置1月就是1-1，设置2月就是2-1，如此类推
		cal.set(Calendar.MONTH, month - 1);
		int MaxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		return MaxDay;
	}
}

