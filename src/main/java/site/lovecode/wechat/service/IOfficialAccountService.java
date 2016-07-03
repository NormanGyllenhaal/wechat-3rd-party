package site.lovecode.wechat.service;


import site.lovecode.wechat.dto.OfficialAccountReqDto;
import site.lovecode.wechat.entity.OfficialAccount;

import java.util.List;

/**
 * Created by Administrator on 2016/4/18.
 */
public interface IOfficialAccountService {

	void saveOfficialAccount(OfficialAccountReqDto officialAccountReqDto);


	List<OfficialAccount> getAllOfficialAccount();
}
