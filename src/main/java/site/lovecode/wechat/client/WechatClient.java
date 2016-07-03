package site.lovecode.wechat.client;


import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import site.lovecode.wechat.support.bean.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/4/20.
 */
public interface WechatClient extends WxMpService {

	/**
	 * 批量获取用户基本信息
	 * @param openidList
	 * @return
	 * @throws WxErrorException
	 */
	List<UserInfoResp> getUserList(List<String> openidList) throws WxErrorException;


	/**
	 * 获取用户自动回复配置
	 * @return
	 * @throws WxErrorException
	 */
	AutoReplyInfoBean getCurrentAutoreplyInfo() throws WxErrorException;




	/**
	 * 获取用户微信后台的菜单配置
	 * @return
	 * @throws WxErrorException
	 */
	SelfMenuInfoBean getSelfMenu() throws WxErrorException;


	/**
	 * 模板消息
	 * 设置公众号所属行业
	 * @throws WxErrorException
	 */
	void setIndustry(IndustryIdBean industryIdBean) throws WxErrorException;


	/**
	 * 获取设置的行业信息
	 * @return
	 * @throws WxErrorException
	 */
	IndustryBean getIndustryInfo() throws WxErrorException;


	/**
	 * 获取模板id
	 * @param templateIdShort
	 * @return
	 * @throws WxErrorException
	 */
	String getTemplateId(String templateIdShort) throws WxErrorException;


	/**
	 * 获取模板列表
	 * @return
	 * @throws WxErrorException
	 */
	TemplateListBean getTemplateList() throws WxErrorException;


	/**
	 * 删除模板
	 * @param templateId
	 * @throws WxErrorException
	 */
	void deleteTemplate(String templateId) throws WxErrorException;


	/**
	 * 发送模板消息
	 * @throws WxErrorException
	 */
	void sendTemplateMessage(String json) throws WxErrorException;


	/**
	 * 
	 * 创建标签
	 * <p>
	 *
	 * @throws WxErrorException 
	 */
	TagBean createTags(TagBean tag) throws WxErrorException;


	/**
	 * 
	 * 获取公众号下所有标签
	 * <p>
	 * 
	 *
	 * @return
	 * @throws WxErrorException 
	 */
	TagsBean getAllTags() throws WxErrorException;


	/**
	 * 
	 * 编辑标签
	 * <p>
	 * 
	 *
	 * @throws WxErrorException 
	 */
	void updateTags(TagBean tag) throws WxErrorException;


	/**
	 * 
	 * 删除标签
	 * <p>
	 * 
	 *
	 * @throws WxErrorException 
	 */
	void deleteTags(TagBean tag) throws WxErrorException;


	/**
	 * 
	 * 获取标签下粉丝列表
	 * <p>
	 * 
	 *
	 * @return
	 * @throws WxErrorException TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	TagsUserBean getTagsUser(String tagid, String nextOpenId) throws WxErrorException;


	/**
	 * 
	 * 批量为用户打标签
	 * <p>
	 * 
	 *
	 * @param openIdList 用户openid列表
	 * @param tagid 标签id
	 */
	void batchTagging(List<String> openIdList, Integer tagid) throws WxErrorException;


	/**
	 * 
	 * 批量为用户取消标签
	 * <p>
	 * 
	 *
	 * @param openIdList 用户openid列表
	 * @param tagId 标签id
	 */
	void batchUntagging(List<String> openIdList, Integer tagId) throws WxErrorException;


	/**
	 * 
	 * 获取用户身上的标签列表
	 * <p>
	 * 
	 *
	 * @param openId 用户openid
	 * @return 
	 */
	TagsIdList getIdList(String openId) throws WxErrorException;


	/**
	 * 
	 * 获取用户增减数据
	 * <p>
	 *
	 * @param beginDate 开始时间
	 * @param endDate 结束时间
	 * @return 
	 */
	UserSummaryBean getUserSummary(String beginDate, String endDate) throws WxErrorException;


	/**
	 * 
	 * 获取累计用户数据
	 * <p>
	 * 
	 *
	 * @param beginDate 开始时间
	 * @param endDate 结束时间
	 * @return 
	 */
	UserCumulateBean getUserCumulateBean(String beginDate, String endDate) throws WxErrorException;


	/**
	 * 
	 * 获取图文群发每日数据
	 * <p>
	 * 
	 *
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws WxErrorException 
	 */
	ArticleSummaryBean getArticleSummary(Date beginDate, Date endDate) throws WxErrorException;


	/**
	 * 
	 * 获取图文群发总数据
	 * <p>
	 * 
	 *
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws WxErrorException TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	ArticleTotalBean getArticleTotal(Date beginDate, Date endDate) throws WxErrorException;


	/**
	 * 
	 * 获取图文统计数据
	 * <p>
	 * 
	 *
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws WxErrorException TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	ArticleDayBean getUserRead(Date beginDate, Date endDate) throws WxErrorException;


	/**
	 * 
	 * 获取图文统计分时数据
	 * <p>
	 *
	 *
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws WxErrorException TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	ArticleHourBean getUserReadHour(Date beginDate, Date endDate) throws WxErrorException;


	/**
	 * 
	 * 获取图文分享转发数据
	 * <p>
	 * TODO(这里可以描述这个方法的执行逻辑，方便看客一目了然的了解代码含义，支持HTML格式化– 可选)
	 *
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws WxErrorException TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	ArticleShareDayBean getUserShare(Date beginDate, Date endDate) throws WxErrorException;


	/**
	 * 
	 * 获取图文分享转发分时数据
	 * <p>
	 * TODO(这里可以描述这个方法的执行逻辑，方便看客一目了然的了解代码含义，支持HTML格式化– 可选)
	 *
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws WxErrorException TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	ArticleShareHourBean getUserShareHour(Date beginDate, Date endDate) throws WxErrorException;


}
