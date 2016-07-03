package site.lovecode.wechat.mapper;


import site.lovecode.wechat.common.mybatis.CommonMapper;
import site.lovecode.wechat.entity.OrgOfficialAccount;

public interface OrgOfficialAccountMapper extends CommonMapper<OrgOfficialAccount> {


	/**
	 * 
	 * 根据机构id获取公众号id
	 * <p>
	 * 
	 *
	 * @param orgId 公众号id
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	Long getOfficialAccountIdByOrgId(Long orgId);
}
