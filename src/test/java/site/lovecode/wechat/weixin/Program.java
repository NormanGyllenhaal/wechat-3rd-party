package site.lovecode.wechat.weixin;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class Program {

	public static void main(String[] args) throws Exception {

		//
		// 第三方回复公众平台
		//

		// 需要加密的明文
		String encodingAesKey = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFG";
		String token = "pamtest";
		String timestamp = "1409304348";
		String nonce = "xxxxxx";
		String appId = "wxb11529c136998cb6";
		String replyMsg = " 中文<xml><ToUserName><![CDATA[oia2TjjewbmiOUlr6X-1crbLOvLw]]></ToUserName><FromUserName><![CDATA[gh_7f083739789a]]></FromUserName><CreateTime>1407743423</CreateTime><MsgType><![CDATA[video]]></MsgType><Video><MediaId><![CDATA[eYJ1MbwPRJtOvIEabaxHs7TX2D-HV71s79GUxqdUkjm6Gs2Ed1KF3ulAOA9H1xG0]]></MediaId><Title><![CDATA[testCallBackReplyVideo]]></Title><Description><![CDATA[testCallBackReplyVideo]]></Description></Video></xml>";

		WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
		String mingwen = pc.encryptMsg(replyMsg, timestamp, nonce);
		System.out.println("加密后: " + mingwen);

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		StringReader sr = new StringReader(mingwen);
		InputSource is = new InputSource(sr);
		Document document = db.parse(is);

		Element root = document.getDocumentElement();
		NodeList nodelist1 = root.getElementsByTagName("Encrypt");
		NodeList nodelist2 = root.getElementsByTagName("MsgSignature");

		String encrypt = nodelist1.item(0).getTextContent();
		String msgSignature = nodelist2.item(0).getTextContent();

		String format = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";
		String fromXML = String.format(format, encrypt);

		//
		// 公众平台发送消息给第三方，第三方处理
		//

		// 第三方收到公众号平台发送的消息
		String result2 = pc.decryptMsg(msgSignature, timestamp, nonce, fromXML);
		System.out.println("解密后明文: " + result2);
		
		//pc.verifyUrl(null, null, null, null);
	}


	@Test
	public void decryptMsg() throws Exception {
		String encodingAesKey = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFG";
		String token = "pamtest";
		String timestamp = "1409304348";
		String nonce = "xxxxxx";
		String appId = "wxb11529c136998cb6";
		//String replyMsg = " 中文<xml><ToUserName><![CDATA[oia2TjjewbmiOUlr6X-1crbLOvLw]]></ToUserName><FromUserName><![CDATA[gh_7f083739789a]]></FromUserName><CreateTime>1407743423</CreateTime><MsgType><![CDATA[video]]></MsgType><Video><MediaId><![CDATA[eYJ1MbwPRJtOvIEabaxHs7TX2D-HV71s79GUxqdUkjm6Gs2Ed1KF3ulAOA9H1xG0]]></MediaId><Title><![CDATA[testCallBackReplyVideo]]></Title><Description><![CDATA[testCallBackReplyVideo]]></Description></Video></xml>";
		WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
		//String mingwen = pc.encryptMsg(replyMsg, timestamp, nonce);

		String mingwen = "<xml>\n" +
				"<Encrypt><![CDATA[YChAmZw/AXVtZ/Z+L4ULf80uT9Zkfc8FpqEsbzOOVulYFOIF5bO+iYNqJF4qD1HZpoubVurJrKX1kYiCUR3QE9oSQtwfN0ugiB3p4Pnss2lIoGK1ZKWZJHt87dV7IXfDhI+CD/wwXSKgnw9d9otJSQjub5hfzACSB6slaA8b2ziGmRkcHYKEFEVTvGsxaIUEPDmlp0smZzV63hGzTcyOMsmMOtQQyMiQdlvqwM1C+MqgKSZkTIiDynQJvnWSxndzM6OQAvUeKdsB7RPTaWkj1ndBlQCTRiasdX/aE/2KSYp3GStO0+7uyvx4d5xnrbei56Tb1NbZcSBERK7jKMayzl0hX70Hj1hSHZ4VhWVt2zXlaor/r163BkT5p/dkyICADck1GHfTMnUQefs3TUKDNQFLcQwNhjTI9g24XC21TidBN7E9fbWipBTwNqDgnm9Wz+tXC0uoYhu+IIkh3jSAYkGTiCyEyy2JxA9C0Otp3ArokfO4yQ1xk73s3JI/e+ErOJKJViYL1vdnVXPIjc9KeKB98px4qEv2f7tv5JjB8kuhwX0+u/ScL33E83NIxsKIFxAaNcq7cgutBpxkYq/hTIzO+imhOlgMyc335dCV1Yjg5JkBPXrlB2PDSvZ3dx4B]]></Encrypt>\n" +
				"<MsgSignature><![CDATA[965d294193d78da8e4f7f0af46db2271880c96a2]]></MsgSignature>\n" +
				"<TimeStamp>1409304348</TimeStamp>\n" +
				"<Nonce><![CDATA[xxxxxx]]></Nonce>\n" +
				"</xml>";
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		StringReader sr = new StringReader(mingwen);
		InputSource is = new InputSource(sr);
		Document document = db.parse(is);
		Element root = document.getDocumentElement();
		NodeList nodelist1 = root.getElementsByTagName("Encrypt");
		NodeList nodelist2 = root.getElementsByTagName("MsgSignature");

		String encrypt = nodelist1.item(0).getTextContent();
		String msgSignature = nodelist2.item(0).getTextContent();

		String format = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";
		String fromXML = String.format(format, encrypt);



		//
		// 公众平台发送消息给第三方，第三方处理
		//

		// 第三方收到公众号平台发送的消息
		String result2 = pc.decryptMsg(msgSignature, timestamp, nonce, fromXML);
		System.out.println("解密后明文: " + result2);
	}
}
