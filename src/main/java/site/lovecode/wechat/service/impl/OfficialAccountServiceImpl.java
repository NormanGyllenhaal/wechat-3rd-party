package site.lovecode.wechat.service.impl;


import org.springframework.stereotype.Service;
import site.lovecode.wechat.dto.OfficialAccountReqDto;
import site.lovecode.wechat.entity.OfficialAccount;
import site.lovecode.wechat.entity.OfficialAccountInfo;
import site.lovecode.wechat.mapper.OfficialAccountInfoMapper;
import site.lovecode.wechat.mapper.OfficialAccountMapper;
import site.lovecode.wechat.service.IOfficialAccountService;
import site.lovecode.wechat.support.enums.OfficialAccountTypeEnum;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/4/18.
 */
@Service
public class OfficialAccountServiceImpl implements IOfficialAccountService {

	@Resource
	private OfficialAccountMapper officialAccountMapper;

	@Resource
	private OfficialAccountInfoMapper officialAccountInfoMapper;


	@Override
	public void saveOfficialAccount( OfficialAccountReqDto officialAccountReqDto ) {
		OfficialAccount officialAccount = new OfficialAccount() {

			private static final long serialVersionUID = 1L;

			{
				setAppid(officialAccountReqDto.getAppid());
				setAccountType(OfficialAccountTypeEnum.UNAUTHORIZATION.key());
				setServiceTypeInfo(officialAccountReqDto.getServiceTypeInfo());
				setVerifyTypeInfo(officialAccountReqDto.getVerifyTypeInfo());
				setNickName(officialAccountReqDto.getNickName());
				setUserName(officialAccountReqDto.getUserName());
			}
		};
		officialAccountMapper.insert(officialAccount);

		officialAccountInfoMapper.insert(new OfficialAccountInfo() {

			private static final long serialVersionUID = 1L;

			{
				setOfficialAccountId(officialAccount.getId());
				setAppid(officialAccountReqDto.getAppid());
				setAppSecret(officialAccountReqDto.getAppSecret());
				setToken(officialAccountReqDto.getToken());
				setEncodingAesKey(officialAccountReqDto.getEncodingAesKey());
				setWechatId(officialAccountReqDto.getWechatId());
				setMessageUrl(officialAccountReqDto.getMessageUrl());
			}
		});
	}


	@Override
	public List<OfficialAccount> getAllOfficialAccount() {
		return officialAccountMapper.selectAll();
	}
}
