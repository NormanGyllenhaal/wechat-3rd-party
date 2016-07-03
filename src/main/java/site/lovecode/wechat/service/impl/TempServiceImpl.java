package site.lovecode.wechat.service.impl;

import site.lovecode.wechat.client.WechatClient;
import site.lovecode.wechat.client.WechatFactory;
import site.lovecode.wechat.mapper.OrgOfficialAccountMapper;
import site.lovecode.wechat.service.ITempService;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.WxMpTemplateMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/6/22.
 */
@Service
public class TempServiceImpl implements ITempService {


    @Resource
    private WechatFactory wechatFactory;


    @Resource
    private OrgOfficialAccountMapper orgOfficialAccountMapper;


    public void sendTempMessage(Long orgId,WxMpTemplateMessage wxMpTemplateMessage) throws WxErrorException {
        WechatClient wechatClient = wechatFactory.getInstance(getOaid(orgId));
        wechatClient.templateSend(wxMpTemplateMessage);
    }


    Long getOaid( Long orgId ) {
        return orgOfficialAccountMapper.getOfficialAccountIdByOrgId(orgId);
    }
}
