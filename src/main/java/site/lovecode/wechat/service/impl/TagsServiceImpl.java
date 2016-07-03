/**
 * TagsServiceImpl.java site.lovecode.wechat.service.impl
 * Copyright (c) 2016, norman.
 */


package site.lovecode.wechat.service.impl;


import me.chanjar.weixin.common.exception.WxErrorException;
import org.springframework.stereotype.Service;
import site.lovecode.wechat.client.WechatClient;
import site.lovecode.wechat.client.WechatFactory;
import site.lovecode.wechat.entity.Tags;
import site.lovecode.wechat.mapper.OrgOfficialAccountMapper;
import site.lovecode.wechat.mapper.TagsMapper;
import site.lovecode.wechat.service.ITagsService;
import site.lovecode.wechat.support.bean.TagBean;
import site.lovecode.wechat.support.bean.TagBean.Tag;
import site.lovecode.wechat.util.Page;

import javax.annotation.Resource;
import java.util.List;


/**
 * 获取公众号所有标签列表
 * <p>
 * TODO(这里描述这个类补充说明 – 可选)
 *
 * @author   Administrator
 * @date	 2016年5月10日 
 * @version  1.0.0	 
 */
@Service
public class TagsServiceImpl  implements ITagsService {


	@Resource
	private TagsMapper tagsMapper;


	@Resource
	private WechatFactory wechatFacoty;


	@Resource
	private OrgOfficialAccountMapper orgOfficialAccountMapper;


	/**
	 * 
	 * 分页获取公众号所有标签
	 * <p>
	 * 
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@Override
	public Page<Tags> getTagsListByPage(Long oaid ) {

		// TODO Auto-generated method stub
		return null;

	}


	/**
	 * 
	 * 获取公众号号所有标签
	 * <p>
	 * 
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@Override
	public List<Tags> getTagsList( Long orgId ) {
		Tags tags = new Tags();
		tags.setOfficialAccountId(getOaid(orgId));
		return tagsMapper.select(tags);

	}


	/**
	 * 
	 * 创建公众号标签
	 * <p>
	 * 
	 *
	 * @param tagsName 标签名称
	 * @return 
	 * @throws WxErrorException 
	 */
	@Override
	public List<Tags> createTags( Long orgId, String tagsName ) throws WxErrorException {
		Long oaid = getOaid(orgId);
		WechatClient wechatClient = wechatFacoty.getInstance(oaid);
		Tag tag = new Tag() {

			{
				setName(tagsName);
			}
		};
		TagBean tagsBean = new TagBean() {

			{
				setTag(tag);
			}
		};
		TagBean tags = wechatClient.createTags(tagsBean);
		tagsMapper.insertSelective(new Tags() {

			private static final long serialVersionUID = 1L;

			{
				setOfficialAccountId(oaid);
				setTagId(tags.getTag().getId());
				setTagName(tags.getTag().getName());

			}
		});
		return getTagsList(oaid);

	}


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
	@Override
	public List<Tags> modifyTags( Long orgId, String tagName, Long id ) throws WxErrorException {
		Long oaid = getOaid(orgId);
		WechatClient wechatClient = wechatFacoty.getInstance(oaid);
		Tags tags = tagsMapper.selectByPrimaryKey(id);
		wechatClient.updateTags(new TagBean() {

			{
				setTag(new Tag() {

					{
						setName(tagName);
						setId(tags.getTagId());
					}
				});
			}
		});
		tagsMapper.updateByPrimaryKeySelective(new Tags() {

			private static final long serialVersionUID = 1L;

			{
				setId(id);
				setTagName(tagName);
			}
		});
		return getTagsList(oaid);
	}


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
	@Override
	public List<Tags> deleteTag( Long orgId, Long id ) throws WxErrorException {
		Long oaid = getOaid(orgId);
		WechatClient wechatClient = wechatFacoty.getInstance(oaid);
		Tags tags = tagsMapper.selectByPrimaryKey(id);
		wechatClient.deleteTags(new TagBean() {

			{
				setTag(new Tag() {

					{
						setId(tags.getTagId());
					}
				});
			}
		});
		tagsMapper.delete(new Tags() {

			private static final long serialVersionUID = 1L;

			{
				setId(id);
			}
		});
		return getTagsList(oaid);
	}


	Long getOaid( Long orgId ) {
		return orgOfficialAccountMapper.getOfficialAccountIdByOrgId(orgId);
	}
}
