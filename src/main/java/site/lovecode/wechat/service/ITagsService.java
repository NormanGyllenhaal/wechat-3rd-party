/**
 * ITagsService.java site.lovecode.wechat.service Copyright (c)
 * 2016, norman.
 */


package site.lovecode.wechat.service;


import me.chanjar.weixin.common.exception.WxErrorException;
import site.lovecode.wechat.entity.Tags;
import site.lovecode.wechat.util.Page;

import java.util.List;


/**
 * 用户标签业务层
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月10日 
 * @version  1.0.0	 
 */
public interface ITagsService {


	/**
	 * 
	 * 分页获取公众号所有标签
	 * <p>
	 * 
	 * @return 
	 */
	Page<Tags> getTagsListByPage(Long orgId);


	/**
	 * 
	 * 获取公众号所有标签
	 * <p>
	 * 
	 * @return 
	 */
	List<Tags> getTagsList(Long orgId);


	/**
	 * 
	 * 创建公众号标签
	 * <p>
	 * 
	 *
	 * @param orgId 公众号id
	 * @param tagsName 标签名称
	 * @return 
	 */
	List<Tags> createTags(Long orgId, String tagsName) throws WxErrorException;


	/**
	 * 
	 * 修改标签
	 * <p>
	 * 
	 *
	 * @param orgId id
	 * @param tagName 标签名称
	 * @return
	 * @throws WxErrorException 
	 */
	 List<Tags> modifyTags(Long orgId, String tagName, Long id) throws WxErrorException;


	/**
	 * 
	 * 删除标签
	 * <p>
	 * 
	 *
	 * @param orgId 公众号id
	 * @param id 标签id
	 * @return
	 * @throws WxErrorException TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	List<Tags> deleteTag(Long orgId, Long id) throws WxErrorException;

}
