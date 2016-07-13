/**
 * IUserDataController.java cn.vko.peixun.web.communicaion.controller Copyright
 * (c) 2016, .
 */


package site.lovecode.wechat.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import site.lovecode.wechat.dto.PersonalUserGroupJoinDto;
import site.lovecode.wechat.entity.UserData;
import site.lovecode.wechat.module.IUserDataModule;
import site.lovecode.wechat.support.common.WebException;
import site.lovecode.wechat.support.enums.EnumConstants;
import site.lovecode.wechat.util.ExcelUtil;
import site.lovecode.wechat.util.Page;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 用户数据
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月20日
 * @version  1.0.0
 */

@RequestMapping( value = "/communication/userData" )
@Controller
public class UserDataController extends BaseController {

	@Resource
	private IUserDataModule userDataModuleImpl;


	/**
	 * 获取用户分析数据
	 * @param model
	 * @return
     */
	@RequestMapping( value = "/getUserData" )
	public String getUserData( Model model ) {
		Date endDate = new Date(new java.util.Date().getTime());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -30);
		Date beginDate = new Date(cal.getTime().getTime());
		Page<UserData> page = userDataModuleImpl.getUserDataPage(
			getPage(), beginDate, endDate, EnumConstants.UserDataOfUserSource.total.key(), getOrgId()).getBody();
		model.addAttribute("page", page);
		return "communication/count/user_data";
	}


	/**
	 * 根据日期和类型取数据
	 * @param beginDate
	 * @param endDate
	 * @param userSource
     * @return
     */
	@RequestMapping( value = "/getUserDataByItem" )
	@ResponseBody
	public String getUserDataByItem( Date beginDate, Date endDate, Integer userSource ) {
		Page<UserData> page = userDataModuleImpl.getUserDataPage(getPage(), beginDate, endDate, userSource, getOrgId())
				.getBody();
		return callback(page,"yyyy-MM-dd");
	}


	/**
	 * 获取用户属性分析数据
	 * @param orgId
	 * @param model
     * @return
     */
	@RequestMapping( value = "/getUserProperty" )
	public String getUserProperty( Long orgId, Model model ) {
		return "communication/count/user_property";
	}


	/**
	 * 获取用户属性
	 * @return
     */
	@RequestMapping(value="/getUserAttribute")
	@ResponseBody
	public String getUserAttribute(){
		PersonalUserGroupJoinDto dto = userDataModuleImpl.getUserProperty(getOrgId()).getBody();
		return callbackSuccess(dto);
	}


	/**
	 * 根据省份获取用户统计数据
	 * @param province
	 * @return
     */
	@RequestMapping(value="/getUserByProvince")
	@ResponseBody
	public String getUserByProvince(String province){
         return callbackSuccess(userDataModuleImpl.getUserByProvince(getOrgId(),province).getBody());
	}


	/**
	 * 导出excel
	 * @param beginDate
	 * @param endDate
	 * @param userSource
	 * @param response
     */
	@RequestMapping(value="/getUserExcel")
	@ResponseBody
	public void getUserExcel( Date beginDate, Date endDate, Integer userSource,HttpServletResponse response ){
		response.reset();
		response.setCharacterEncoding("UTF-8");
		String docName = null;
		try {
			docName = URLEncoder.encode("用户增长数据表.xls", "UTF-8");
			OutputStream out = response.getOutputStream();
			response.setContentType("application/x-msdownload;charset=UTF-8");
			response.setHeader("Content-disposition", "attachment; filename=" + docName);
			List<UserData> userDataList = userDataModuleImpl.getUserDataList(beginDate, endDate, userSource, getOrgId()).getBody();
			List<Map<String, Object>> mapList = userDataList.stream().map(userData -> userData.toMap()).collect(Collectors.toList());
			ExcelUtil.getExcelFile("execl", docName, mapList).write(out);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebException("导出失败");
		}

	}
}
