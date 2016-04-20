package site.lovecode.client;

import com.alibaba.fastjson.JSON;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import site.lovecode.jedis.RedisCache;
import site.lovecode.support.bean.config.WechatConfig;
import site.lovecode.support.bean.enums.OfficialAccountTypeEnum;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/4/19.
 */


@Service
public class WechatFactory  {


    @Resource
    private WxMpService wechatAuthorizationClient;

    @Resource
    private WxMpService wechatBindClient;

    @Resource
    private RedisCache redisCache;


    public WxMpService getWxMpService() {
        if(RequestContextHolder.getRequestAttributes()!=null){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            Long officialAccountId = Long.parseLong(request.getParameter("oaid"));
            WechatConfig wechatConfig = JSON.parseObject(redisCache.get(officialAccountId), WechatConfig.class);
            if (wechatConfig.getAccountType().equals(OfficialAccountTypeEnum.AUTHORIZATION.key())) {
                wechatAuthorizationClient.setWxMpConfigStorage(wechatConfig);
                return wechatAuthorizationClient;
            } else {
                wechatBindClient.setWxMpConfigStorage(wechatConfig);
                return wechatBindClient;
            }
        }else{
            return null;
        }

    }

}
