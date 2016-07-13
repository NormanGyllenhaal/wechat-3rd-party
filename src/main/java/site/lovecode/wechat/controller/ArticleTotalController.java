/**
 * ArticleTotalController.java cn.vko.peixun.web.communicaion.controller
 * Copyright (c) 2016, .
 */


package site.lovecode.wechat.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import site.lovecode.wechat.dto.ArticleTotalDto;
import site.lovecode.wechat.module.IArticleTotalModule;
import site.lovecode.wechat.support.common.WebException;
import site.lovecode.wechat.util.ExcelUtil;
import site.lovecode.wechat.util.Page;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.List;
import java.util.Map;


/**
 * 图文统计
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月21日
 * @version  1.0.0
 */


@Controller
@RequestMapping( "/communication/article" )
public class ArticleTotalController extends BaseController {

	@Resource
	private IArticleTotalModule articleTotalModuleImpl;


	/**
	 * 获取单篇图文列表
	 * @param beginDate
	 * @param endDate
	 * @param model
     * @return
     */
	@RequestMapping( value = "/getArticleOne" )
	public String getArticleOne(Date beginDate,Date endDate,Model model) {
		Page<ArticleTotalDto> page = articleTotalModuleImpl.getArticleOne(getPage(), getOrgId(), beginDate, endDate).getBody();
		model.addAttribute("page",page);
		return "communication/count/article_analysis_one";
	}


	/**
	 * ajax获取单篇图文列表
	 * @param beginDate
	 * @param endDate
	 * @param model
     * @return
     */
	@RequestMapping(value="/getArticleOneAjax")
	@ResponseBody
	public String getArticleOneAjax(Date beginDate,Date endDate,Model model){
		Page<ArticleTotalDto> page = articleTotalModuleImpl.getArticleOne(getPage(), getOrgId(), beginDate, endDate).getBody();
		return callback(page,"yyyy-MM-dd");
	}


	/**
	 * 获取单篇图文详情
	 * @param id
	 * @param beginDate
	 * @param endDate
     * @return
     */
	@RequestMapping(value="/etArticleOneDetail")
	@ResponseBody
	public String getArticleOneDetail(Long id,Date beginDate,Date endDate){
		ArticleTotalDto totalDto = articleTotalModuleImpl.getArticleOneDetail(id, beginDate, endDate).getBody();
		return callback(totalDto,"yyyy-MM-dd");
	}


	@RequestMapping( value = "/getArticleDay" )
	public String getArticleDay() {
		return "communication/count/article_analysis_all";
	}


	/**
	 * 获取图文每天
	 * @param beginDate
	 * @param endDate
     * @return
     */
	@RequestMapping( value = "/getArticleDayAjax" )
	@ResponseBody
	public String getArticleDayAjax( Date beginDate, Date endDate ) {
		return callback(articleTotalModuleImpl.getArticleDay(getPage(),getOrgId(), beginDate, endDate).getBody(),"yyyy-MM-dd");
	}


	/**
	 * 分页获取每日图文
	 * @param beginDate
	 * @param endDate
	 * @return
     */
	@RequestMapping(value="/getArticleDayPage")
	@ResponseBody
	public String getArticleDayPage(Date beginDate, Date endDate){
		return callback(articleTotalModuleImpl.getArticelDayPage(getPage(),getOrgId(),beginDate,endDate).getBody(),"yyyy-MM-dd");
	}


	/**
	 * 获取图文每小时
	 * @param date
	 * @return
     */
	@RequestMapping( value = "/getArticleHour" )
	@ResponseBody
	public String getArticleHour( Date date ) {
		return callback(articleTotalModuleImpl.getArticleHour(getOrgId(), date,getPage()).getBody(),"yyyy-MM-dd");
	}


	/**
	 * 分页获取图文每小时数据
	 * @param date
	 * @return
     */
	@RequestMapping(value="/getArticleHourPage")
	@ResponseBody
	public String getArticleHourPage(Date date){
		return callback(articleTotalModuleImpl.getArticleHourPage(getOrgId(),date,getPage()).getBody(),"yyyy-MM-dd");
	}


	/**
	 * 导出每日excel数据
	 * @param beginDate
	 * @param endDate
	 * @param response
     */
	@RequestMapping(value="/getArticleDayExcel")
	@ResponseBody
	public void getArticleDayExcel(Date beginDate, Date endDate,HttpServletResponse response){
		response.reset();
		response.setCharacterEncoding("UTF-8");
		String docName = null;
		try {
			docName = URLEncoder.encode("用户图文阅读每日数据表.xls", "UTF-8");
			OutputStream out = response.getOutputStream();
			response.setContentType("application/x-msdownload;charset=UTF-8");
			response.setHeader("Content-disposition", "attachment; filename=" + docName);
			List<Map<String,Object>> list = articleTotalModuleImpl.getArticleDayExcel(getOrgId(),beginDate,endDate).getBody();
			ExcelUtil.getExcelFile("execl", docName, list).write(out);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebException("导出失败");
		}
	}


	/**
	 * 导出每小时excel数据
	 * @param date
	 * @param response
     */
	@RequestMapping(value="/getArticleHourExcel")
	@ResponseBody
	public void getArticleHourExcel(Date date,HttpServletResponse response){
		response.reset();
		response.setCharacterEncoding("UTF-8");
		String docName = null;
		try {
			docName = URLEncoder.encode("用户图文阅读小时数据表.xls", "UTF-8");
			OutputStream out = response.getOutputStream();
			response.setContentType("application/x-msdownload;charset=UTF-8");
			response.setHeader("Content-disposition", "attachment; filename=" + docName);
			List<Map<String,Object>> list = articleTotalModuleImpl.getArticleHourExcel(getOrgId(),date).getBody();
			ExcelUtil.getExcelFile("execl", docName, list).write(out);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebException("导出失败");
		}

	}

}
