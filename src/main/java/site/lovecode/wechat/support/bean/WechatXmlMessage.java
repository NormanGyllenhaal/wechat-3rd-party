package site.lovecode.wechat.support.bean;


import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import org.apache.commons.io.IOUtils;
import site.lovecode.wechat.entity.WechatThirdPartyConfig;
import site.lovecode.wechat.util.WechatCryptUtil;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/4/25.
 */
public class WechatXmlMessage extends WxMpXmlMessage {

	/**
	 * TODO（用一句话描述这个变量的含义）
	 */

	private static final long serialVersionUID = 1L;


	public static WxMpXmlMessage fromEncryptedXml(
			InputStream is, WechatThirdPartyConfig wechatThirdPartyConfig, String timestamp, String nonce,
			String msgSignature ) {
		try {
			return fromEncryptedXml(
				IOUtils.toString(is, "UTF-8"), wechatThirdPartyConfig, timestamp, nonce, msgSignature);
		} catch ( IOException e ) {
			throw new RuntimeException(e);
		}
	}


	public static WxMpXmlMessage fromEncryptedXml(
			String encryptedXml, WechatThirdPartyConfig wechatThirdPartyConfig, String timestamp, String nonce,
			String msgSignature ) {
		WechatCryptUtil cryptUtil = new WechatCryptUtil(wechatThirdPartyConfig);
		String plainText = cryptUtil.decrypt(msgSignature, timestamp, nonce, encryptedXml);
		return fromXml(plainText);
	}

}
