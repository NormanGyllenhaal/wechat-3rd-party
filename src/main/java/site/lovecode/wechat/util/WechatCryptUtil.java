package site.lovecode.wechat.util;

import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.util.xml.XStreamTransformer;
import org.apache.commons.codec.binary.Base64;
import site.lovecode.wechat.entity.WechatThirdPartyConfig;


/**
 * Created by Administrator on 2016/4/25.
 */
public class WechatCryptUtil extends me.chanjar.weixin.common.util.crypto.WxCryptUtil {


	/**
	 * 构造函数
	 *
	 * @param wechatThirdPartyConfig
	 */
	public WechatCryptUtil( WechatThirdPartyConfig wechatThirdPartyConfig ) {
		/*
		 * @param token          公众平台上，开发者设置的token
		 * @param encodingAesKey 公众平台上，开发者设置的EncodingAESKey
		 * @param appId          公众平台appid
		 */
		String encodingAesKey = wechatThirdPartyConfig.getEncodeingAesKey();
		String token = wechatThirdPartyConfig.getToken();
		String appId = wechatThirdPartyConfig.getComponentAppid();

		this.token = token;
		this.appidOrCorpid = appId;
		this.aesKey = Base64.decodeBase64(encodingAesKey + "=");
	}


	/**
	 * 转换成加密的xml格式
	 * @return
	 */
	public static String toEncryptedXml(
			WechatThirdPartyConfig wechatThirdPartyConfig, WxMpXmlOutMessage wxMpXmlOutMessage ) {
		String plainXml = XStreamTransformer.toXml((Class) wxMpXmlOutMessage.getClass(), wxMpXmlOutMessage);
		WechatCryptUtil wechatCryptUtil = new WechatCryptUtil(wechatThirdPartyConfig);
		return wechatCryptUtil.encrypt(plainXml);
	}

}
