package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table( name = "WX_MESSAGE_SEND_HOUR" )
public class MessageSendHour implements Identity, Serializable {

	/**
	 * 主键
	 */
	@Id
	private Long id;

	/**
	 * 数据的日期
	 */
	private Date refDate;

	/**
	 * 数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
	 */
	private Integer refHour;

	/**
	 * 消息类型，代表含义如下：
	        1代表文字 2代表图片 3代表语音 4代表视频 6代表第三方应用消息（链接消息）
	 */
	private Integer msgType;

	/**
	 * 上行发送了（向公众号发送了）消息的用户数
	        
	 */
	private Integer msgUser;

	/**
	 * 上行发送了消息的消息总数
	 */
	private Integer msgCount;

	private static final long serialVersionUID = 1L;


	/**
	 * 获取主键
	 *
	 * @return id - 主键
	 */
	@Override
	public Long getId() {
		return id;
	}


	/**
	 * 设置主键
	 *
	 * @param id 主键
	 */
	@Override
	public void setId( Long id ) {
		this.id = id;
	}


	/**
	 * 获取数据的日期
	 *
	 * @return refDate - 数据的日期
	 */
	public Date getRefDate() {
		return refDate;
	}


	/**
	 * 设置数据的日期
	 *
	 * @param refDate 数据的日期
	 */
	public void setRefDate( Date refDate ) {
		this.refDate = refDate;
	}


	/**
	 * 获取数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
	 *
	 * @return refHour - 数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
	 */
	public Integer getRefHour() {
		return refHour;
	}


	/**
	 * 设置数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
	 *
	 * @param refHour 数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
	 */
	public void setRefHour( Integer refHour ) {
		this.refHour = refHour;
	}


	/**
	 * 获取消息类型，代表含义如下：
	        1代表文字 2代表图片 3代表语音 4代表视频 6代表第三方应用消息（链接消息）
	 *
	 * @return msgType - 消息类型，代表含义如下：
	        1代表文字 2代表图片 3代表语音 4代表视频 6代表第三方应用消息（链接消息）
	 */
	public Integer getMsgType() {
		return msgType;
	}


	/**
	 * 设置消息类型，代表含义如下：
	        1代表文字 2代表图片 3代表语音 4代表视频 6代表第三方应用消息（链接消息）
	 *
	 * @param msgType 消息类型，代表含义如下：
	        1代表文字 2代表图片 3代表语音 4代表视频 6代表第三方应用消息（链接消息）
	 */
	public void setMsgType( Integer msgType ) {
		this.msgType = msgType;
	}


	/**
	 * 获取上行发送了（向公众号发送了）消息的用户数
	        
	 *
	 * @return msgUser - 上行发送了（向公众号发送了）消息的用户数
	        
	 */
	public Integer getMsgUser() {
		return msgUser;
	}


	/**
	 * 设置上行发送了（向公众号发送了）消息的用户数
	        
	 *
	 * @param msgUser 上行发送了（向公众号发送了）消息的用户数
	        
	 */
	public void setMsgUser( Integer msgUser ) {
		this.msgUser = msgUser;
	}


	/**
	 * 获取上行发送了消息的消息总数
	 *
	 * @return msgCount - 上行发送了消息的消息总数
	 */
	public Integer getMsgCount() {
		return msgCount;
	}


	/**
	 * 设置上行发送了消息的消息总数
	 *
	 * @param msgCount 上行发送了消息的消息总数
	 */
	public void setMsgCount( Integer msgCount ) {
		this.msgCount = msgCount;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", refDate=").append(refDate);
		sb.append(", refHour=").append(refHour);
		sb.append(", msgType=").append(msgType);
		sb.append(", msgUser=").append(msgUser);
		sb.append(", msgCount=").append(msgCount);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
