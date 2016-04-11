package site.lovecode.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import site.lovecode.client.WechatThirdPartyClient;
import site.lovecode.client.impl.WechatThirdPartyClientImpl;
import site.lovecode.entity.ComponentAccessToken;
import site.lovecode.entity.ComponentVerifyTicket;
import site.lovecode.entity.WechatThirdPartyConfig;
import site.lovecode.mapper.ComponentVerifyTicketMapper;
import site.lovecode.mapper.WechatThirdPartyConfigMapper;
import site.lovecode.service.WechatThridPartyService;
import site.lovecode.support.bean.AuthorizerInfoBean;
import site.lovecode.support.bean.OpenidBean;
import site.lovecode.support.bean.QueryAuthBean;
import site.lovecode.support.bean.TicketDecryptingBean;
import site.lovecode.util.HttpUtil;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2016/4/8.
 */
@Service
public class WechatThirdPartyServiceImpl implements InitializingBean,WechatThridPartyService{


    private Logger logger = LoggerFactory.getLogger(WechatThirdPartyServiceImpl.class);

    @Resource
    private ComponentVerifyTicketMapper componentVerifyTicketMapper;


    @Resource
    private WechatThirdPartyConfigMapper wechatThirdPartyConfigMapper;

    @Resource
    private WechatThirdPartyClient wechatThirdPartyClient;

    /**
     * 初始化加载公众号配置信息
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("----加载公众号第三方配置----");
        WechatThirdPartyClientImpl.wechatThirdPartyConfig = wechatThirdPartyConfigMapper.selectByPrimaryKey(1L);
        //获取已经存储的ticket
        ComponentVerifyTicket componentVerifyTicket = componentVerifyTicketMapper.selectOrderByCreateTime(WechatThirdPartyClientImpl.wechatThirdPartyConfig.getComponentAppid());
        if(Optional.ofNullable(componentVerifyTicket).isPresent()&&componentVerifyTicket.getDeadline().getTime()>System.currentTimeMillis()){
            WechatThirdPartyClientImpl.wechatThirdPartyConfig.setComponentVerifyTicket(componentVerifyTicket.getComponentVerifyTicket());
            WechatThirdPartyClientImpl.wechatThirdPartyConfig.setComponentAccessToken(wechatThirdPartyClient.refreshComponentAccessToken().getComponentAccessToken());
        }
        logger.info(WechatThirdPartyClientImpl.wechatThirdPartyConfig.toString());
    }


    /**
     * 保存ComponentVerifyTicket
     *
     * @param ticketDecryptingBean
     */
    @Override
    public void saveComponentVerifyTicket(TicketDecryptingBean ticketDecryptingBean) {
        //更新内存中的componentVerfiyTicket
        WechatThirdPartyClientImpl.wechatThirdPartyConfig.setComponentVerifyTicket(ticketDecryptingBean.getComponentVerifyTicket());
        //检查componentAccessToken是否为空
       if(StringUtils.isEmpty(WechatThirdPartyClientImpl.wechatThirdPartyConfig.getComponentAccessToken())){
           WechatThirdPartyClientImpl.wechatThirdPartyConfig.setComponentAccessToken(wechatThirdPartyClient.refreshComponentAccessToken().getComponentAccessToken());
       }
        //保存到数据库
        componentVerifyTicketMapper.insert(new ComponentVerifyTicket() {
            {
                setComponentVerifyTicket(ticketDecryptingBean.getComponentVerifyTicket());
                setCreateTime(new Timestamp(Long.parseLong(ticketDecryptingBean.getCreateTime()) * 1000));
                setComponentAppid(ticketDecryptingBean.getAppId());
                setDeadline(new Timestamp(System.currentTimeMillis()+(60*60*1000)));
            }
        });
    }

    /**
     * 保存用户信息
     * @param authCode
     * @throws IOException
     */
    public AuthorizerInfoBean saveAuthorizerInfo(String authCode) throws Exception {
        QueryAuthBean queryAuthBean = wechatThirdPartyClient.queryAuth(authCode);
        //List<String> opendidList = getOpenIdList(queryAuthBean.getAuthOrizationInfo().getAuthorizerAccessToken());
        AuthorizerInfoBean authorizerInfoBean = wechatThirdPartyClient.getAuthorizerInfo(queryAuthBean.getAuthOrizationInfo().getAuthorizerAppid());
        logger.info(queryAuthBean.toString());
        logger.info(authorizerInfoBean.toString());
        return authorizerInfoBean;
    }



    /**
     * 生成用户的授权页面
     * @return
     * @throws IOException
     */
    public String  getCompoentLoginUrl() throws IOException {
        return wechatThirdPartyClient.getAuthOrizationUrl(wechatThirdPartyClient.getPreAuthCode().getPreAuthCode());
    }


    public WxMpService getWxMpService(String appid,String accessToken) {
        WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        config.setAppId(appid); // 设置微信公众号的appid
        config.setSecret("");
        config.setToken(accessToken); // 设置微信公众号的token
        WxMpService wxService = new WxMpServiceImpl();
        wxService.setWxMpConfigStorage(config);
        return wxService;
    }


    public List<String> getOpenIdList(String accessToken){
        String str = HttpUtil.doGet(Stream.of("https://api.weixin.qq.com/cgi-bin/user/get?access_token=",accessToken,"=&next_openid=").reduce("",String::concat));
        logger.info(str);
        OpenidBean openidBean = JSON.parseObject(str, OpenidBean.class);
        logger.info(openidBean.toString());
        return openidBean.getData().getOpenid();
    }

}
