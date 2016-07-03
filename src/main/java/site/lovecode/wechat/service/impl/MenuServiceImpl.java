package site.lovecode.wechat.service.impl;


import me.chanjar.weixin.common.exception.WxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import site.lovecode.wechat.client.WechatClient;
import site.lovecode.wechat.client.WechatFactory;
import site.lovecode.wechat.dto.MenuDto;
import site.lovecode.wechat.dto.MenuMediaDto;
import site.lovecode.wechat.dto.MenuReqDto;
import site.lovecode.wechat.mapper.MenuMapper;
import site.lovecode.wechat.mapper.OrgOfficialAccountMapper;
import site.lovecode.wechat.service.IMenuService;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/4/19.
 */
@Service
public class MenuServiceImpl implements IMenuService {

	private final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

	@Resource
	private WechatFactory wechatFactory;

	@Resource
	private MenuMapper menuMapper;


	@Resource
	private OrgOfficialAccountMapper orgOfficialAccountMapper;


	/**
	 * 
	 * 创建自定义菜单
	 * <p>
	 * 
	 *
	 * @param menuReqDto 菜单列表
	 * @param orgId
	 * @throws WxErrorException 
	 */
	@Override
	public void createMenu(MenuReqDto menuReqDto, Long orgId ) throws WxErrorException {
		WechatClient wechatClient = wechatFactory.getInstance(getOaid(orgId));
		//wechatClient.createMeun(menuReqDto);

	}


	/**
	 * 
	 * 根据机构id获取菜单列表
	 * <p>
	 * 
	 *
	 * @param orgId
	 * @return
	 */
	@Override
	public MenuDto getMenu(Long orgId ) {
		return menuMapper.selectMenuJoinSelf(getOaid(orgId));
	}


	/**
	 * 
	 * 根据菜单id获取菜单信息
	 * <p>
	 * 
	 *
	 * @param menuId
	 * @return
	 */
	@Override
	public MenuMediaDto getMenuOne(Long menuId ) {
		return menuMapper.selectJoinMedia(menuId);
	}


	Long getOaid( Long orgId ) {
		return orgOfficialAccountMapper.getOfficialAccountIdByOrgId(orgId);
	}

}
