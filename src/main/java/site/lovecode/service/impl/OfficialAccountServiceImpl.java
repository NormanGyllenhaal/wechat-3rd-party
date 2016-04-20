package site.lovecode.service.impl;

import org.springframework.stereotype.Service;
import site.lovecode.entity.OfficialAccount;
import site.lovecode.entity.OfficialAccountInfo;
import site.lovecode.mapper.OfficialAccountInfoMapper;
import site.lovecode.mapper.OfficialAccountMapper;
import site.lovecode.service.OfficialAccountService;
import site.lovecode.support.bean.enums.OfficialAccountTypeEnum;
import site.lovecode.support.bean.request.OfficialAccountReq;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/4/18.
 */
@Service
public class OfficialAccountServiceImpl implements OfficialAccountService {

    @Resource
    private OfficialAccountMapper officialAccountMapper;

    @Resource
    private OfficialAccountInfoMapper officialAccountInfoMapper;

    @Override
    public void saveOfficialAccount(OfficialAccountReq officialAccountReq) {
        OfficialAccount officialAccount = new OfficialAccount() {
            {
                setAppid(officialAccountReq.getAppid());
                setAccountType(OfficialAccountTypeEnum.UNAUTHORIZATION.key());
                setServiceTypeInfo(officialAccountReq.getServiceTypeInfo());
                setVerifyTypeInfo(officialAccountReq.getVerifyTypeInfo());
                setNickName(officialAccountReq.getNickName());
                setUserName(officialAccountReq.getUserName());
            }
        };
        officialAccountMapper.insert(officialAccount);

        officialAccountInfoMapper.insert(new OfficialAccountInfo() {
            {
                setOfficialAccountId(officialAccount.getId());
                setAppid(officialAccountReq.getAppid());
                setAppSecret(officialAccountReq.getAppSecret());
                setToken(officialAccountReq.getToken());
                setEncodingAesKey(officialAccountReq.getEncodingAesKey());
                setWechatId(officialAccountReq.getWechatId());
                setMessageUrl(officialAccountReq.getMessageUrl());
            }
        });
    }


    public List<OfficialAccount> getAllOfficialAccount(){
        return officialAccountMapper.selectAll();
    }
}
