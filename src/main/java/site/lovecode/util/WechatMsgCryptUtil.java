package site.lovecode.util;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import com.thoughtworks.xstream.XStream;
import site.lovecode.client.impl.WechatThirdPartyClientImpl;
import site.lovecode.support.bean.XmlEncryptingBean;

import java.io.InputStream;

/**
 * Created by Administrator on 2016/4/11.
 */
public class WechatMsgCryptUtil {



    private static final String FORMAT = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";

    public static  String WechatMsgDecrypt(InputStream inputStream,String msgSignature, String timestamp, String nonce) throws AesException {
        WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt(WechatThirdPartyClientImpl.wechatThirdPartyConfig.getToken(), WechatThirdPartyClientImpl.wechatThirdPartyConfig.getEncodeingAesKey(), WechatThirdPartyClientImpl.wechatThirdPartyConfig.getComponentAppid());
        XmlEncryptingBean xmlEncryptingBean = (XmlEncryptingBean) new XStream() {
            {
                processAnnotations(XmlEncryptingBean.class);
            }
        }.fromXML(inputStream);
        return wxBizMsgCrypt.decryptMsg(msgSignature, timestamp,nonce, String.format(FORMAT, xmlEncryptingBean.getEncrypt()));
    }
}
