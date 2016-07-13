package site.lovecode.wechat.util;

import com.thoughtworks.xstream.XStream;
import me.chanjar.weixin.common.util.xml.XStreamInitializer;
import site.lovecode.wechat.ase.AesException;
import site.lovecode.wechat.ase.WXBizMsgCrypt;
import site.lovecode.wechat.client.impl.WechatThirdPartyClientImpl;
import site.lovecode.wechat.support.bean.XmlEncryptingBean;

;

/**
 * Created by Administrator on 2016/4/11.
 */
public class WechatMsgCryptUtil {


	private static final String FORMAT = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";


	public static String WechatMsgDecrypt( String str, String msgSignature, String timestamp, String nonce )
		throws AesException {
		WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt(
				WechatThirdPartyClientImpl.wechatThirdPartyConfig.getToken(),
				WechatThirdPartyClientImpl.wechatThirdPartyConfig.getEncodeingAesKey(),
				WechatThirdPartyClientImpl.wechatThirdPartyConfig.getComponentAppid());
		XStream xStream = XStreamInitializer.getInstance();
		xStream.processAnnotations(new Class[ ] { XmlEncryptingBean.class });
		XmlEncryptingBean xmlEncryptingBean = (XmlEncryptingBean) xStream.fromXML(str);
		return wxBizMsgCrypt.decryptMsg(
			msgSignature, timestamp, nonce, String.format(FORMAT, xmlEncryptingBean.getEncrypt()));
	}
}
