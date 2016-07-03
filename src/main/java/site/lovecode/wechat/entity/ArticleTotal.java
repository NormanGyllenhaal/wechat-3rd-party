package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;
import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table( name = "WX_ARTICLE_TOTAL" )
public class ArticleTotal implements Identity, Serializable {

	/**
	 * 主键
	 */
	@Id
	private Long id;

	/**
	 * 微信公众账号基本信息id
	 */
	private Long officialAccountId;

	/**
	 * 数据的日期
	 */

	private Date refDate;

	/**
	 * 这里的msgid实际上是由msgid（图文消息id，这也就是群发接口调用后返回的msg_data_id）和index（消息次序索引）组成， 例如12003_3， 其中12003是msgid，即一次群发的消息的id； 3为index，假设该次群发的图文消息共5个文章（因为可能为多图文），3表示5个中的第3个
	 */
	private String msgid;

	/**
	 * 图文消息的标题
	 */
	private String title;

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
	 * 获取微信公众账号基本信息id
	 *
	 * @return officialAccountId - 微信公众账号基本信息id
	 */
	public Long getOfficialAccountId() {
		return officialAccountId;
	}


	/**
	 * 设置微信公众账号基本信息id
	 *
	 * @param officialAccountId 微信公众账号基本信息id
	 */
	public void setOfficialAccountId( Long officialAccountId ) {
		this.officialAccountId = officialAccountId;
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
	@JSONField( name = "ref_date" )
	public void setRefDate( Date refDate ) {
		this.refDate = refDate;
	}


	/**
	 * 获取这里的msgid实际上是由msgid（图文消息id，这也就是群发接口调用后返回的msg_data_id）和index（消息次序索引）组成， 例如12003_3， 其中12003是msgid，即一次群发的消息的id； 3为index，假设该次群发的图文消息共5个文章（因为可能为多图文），3表示5个中的第3个
	 *
	 * @return msgid - 这里的msgid实际上是由msgid（图文消息id，这也就是群发接口调用后返回的msg_data_id）和index（消息次序索引）组成， 例如12003_3， 其中12003是msgid，即一次群发的消息的id； 3为index，假设该次群发的图文消息共5个文章（因为可能为多图文），3表示5个中的第3个
	 */
	public String getMsgid() {
		return msgid;
	}


	/**
	 * 设置这里的msgid实际上是由msgid（图文消息id，这也就是群发接口调用后返回的msg_data_id）和index（消息次序索引）组成， 例如12003_3， 其中12003是msgid，即一次群发的消息的id； 3为index，假设该次群发的图文消息共5个文章（因为可能为多图文），3表示5个中的第3个
	 *
	 * @param msgid 这里的msgid实际上是由msgid（图文消息id，这也就是群发接口调用后返回的msg_data_id）和index（消息次序索引）组成， 例如12003_3， 其中12003是msgid，即一次群发的消息的id； 3为index，假设该次群发的图文消息共5个文章（因为可能为多图文），3表示5个中的第3个
	 */
	public void setMsgid( String msgid ) {
		this.msgid = msgid;
	}


	/**
	 * 获取图文消息的标题
	 *
	 * @return title - 图文消息的标题
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * 设置图文消息的标题
	 *
	 * @param title 图文消息的标题
	 */
	public void setTitle( String title ) {
		this.title = title;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", officialAccountId=").append(officialAccountId);
		sb.append(", refDate=").append(refDate);
		sb.append(", msgid=").append(msgid);
		sb.append(", title=").append(title);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
