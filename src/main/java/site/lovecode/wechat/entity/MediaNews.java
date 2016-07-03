package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table( name = "WX_MEDIA_NEWS" )
public class MediaNews implements Identity, Serializable {

	@Id
	private Long id;

	/**
	 * 关联微信素材信息表id
	 */
	private Long myMediaId;

	/**
	 * 图文消息的标题
	 */
	private String title;

	/**
	 * 图文消息的封面图片素材id（必须是永久mediaID）
	 */
	private String thumbMediaId;

	/**
	 * 图文消息的封面图片的地址，第三方开发者也可以使用这个URL下载图片到自己服务器中，然后显示在自己网站上
	 */
	private String thumbUrl;

	/**
	 * 是否显示封面，0为false，即不显示，1为true，即显示
	 */
	private Integer showCoverPic;

	/**
	 * 作者
	 */
	private String author;

	/**
	 * 图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
	 */
	private String digest;

	/**
	 * 图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
	 */
	private String content;

	/**
	 * 图文页的URL，或者，当获取的列表是图片素材列表时，该字段是图片的URL
	 */
	private String url;

	/**
	 * 图文消息的原文地址，即点击“阅读原文”后的URL
	 */
	private String contentSourceUrl;

	/**
	 * 文章排序
	 */
	private Integer orderNum;

	private static final long serialVersionUID = 1L;


	/**
	 * @return id
	 */
	@Override
	public Long getId() {
		return id;
	}


	/**
	 * @param id
	 */
	@Override
	public void setId( Long id ) {
		this.id = id;
	}


	/**
	 * 获取关联微信素材信息表id
	 *
	 * @return myMediaId - 关联微信素材信息表id
	 */
	public Long getMyMediaId() {
		return myMediaId;
	}


	/**
	 * 设置关联微信素材信息表id
	 *
	 * @param myMediaId 关联微信素材信息表id
	 */
	public void setMyMediaId( Long myMediaId ) {
		this.myMediaId = myMediaId;
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


	/**
	 * 获取图文消息的封面图片素材id（必须是永久mediaID）
	 *
	 * @return thumbMediaId - 图文消息的封面图片素材id（必须是永久mediaID）
	 */
	public String getThumbMediaId() {
		return thumbMediaId;
	}


	/**
	 * 设置图文消息的封面图片素材id（必须是永久mediaID）
	 *
	 * @param thumbMediaId 图文消息的封面图片素材id（必须是永久mediaID）
	 */
	public void setThumbMediaId( String thumbMediaId ) {
		this.thumbMediaId = thumbMediaId;
	}


	/**
	 * 获取图文消息的封面图片的地址，第三方开发者也可以使用这个URL下载图片到自己服务器中，然后显示在自己网站上
	 *
	 * @return thumbUrl - 图文消息的封面图片的地址，第三方开发者也可以使用这个URL下载图片到自己服务器中，然后显示在自己网站上
	 */
	public String getThumbUrl() {
		return thumbUrl;
	}


	/**
	 * 设置图文消息的封面图片的地址，第三方开发者也可以使用这个URL下载图片到自己服务器中，然后显示在自己网站上
	 *
	 * @param thumbUrl 图文消息的封面图片的地址，第三方开发者也可以使用这个URL下载图片到自己服务器中，然后显示在自己网站上
	 */
	public void setThumbUrl( String thumbUrl ) {
		this.thumbUrl = thumbUrl;
	}


	/**
	 * 获取是否显示封面，0为false，即不显示，1为true，即显示
	 *
	 * @return showCoverPic - 是否显示封面，0为false，即不显示，1为true，即显示
	 */
	public Integer getShowCoverPic() {
		return showCoverPic;
	}


	/**
	 * 设置是否显示封面，0为false，即不显示，1为true，即显示
	 *
	 * @param showCoverPic 是否显示封面，0为false，即不显示，1为true，即显示
	 */
	public void setShowCoverPic( Integer showCoverPic ) {
		this.showCoverPic = showCoverPic;
	}


	/**
	 * 获取作者
	 *
	 * @return author - 作者
	 */
	public String getAuthor() {
		return author;
	}


	/**
	 * 设置作者
	 *
	 * @param author 作者
	 */
	public void setAuthor( String author ) {
		this.author = author;
	}


	/**
	 * 获取图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
	 *
	 * @return digest - 图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
	 */
	public String getDigest() {
		return digest;
	}


	/**
	 * 设置图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
	 *
	 * @param digest 图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
	 */
	public void setDigest( String digest ) {
		this.digest = digest;
	}


	/**
	 * 获取图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
	 *
	 * @return content - 图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
	 */
	public String getContent() {
		return content;
	}


	/**
	 * 设置图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
	 *
	 * @param content 图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
	 */
	public void setContent( String content ) {
		this.content = content;
	}


	/**
	 * 获取图文页的URL，或者，当获取的列表是图片素材列表时，该字段是图片的URL
	 *
	 * @return url - 图文页的URL，或者，当获取的列表是图片素材列表时，该字段是图片的URL
	 */
	public String getUrl() {
		return url;
	}


	/**
	 * 设置图文页的URL，或者，当获取的列表是图片素材列表时，该字段是图片的URL
	 *
	 * @param url 图文页的URL，或者，当获取的列表是图片素材列表时，该字段是图片的URL
	 */
	public void setUrl( String url ) {
		this.url = url;
	}


	/**
	 * 获取图文消息的原文地址，即点击“阅读原文”后的URL
	 *
	 * @return contentSourceUrl - 图文消息的原文地址，即点击“阅读原文”后的URL
	 */
	public String getContentSourceUrl() {
		return contentSourceUrl;
	}


	/**
	 * 设置图文消息的原文地址，即点击“阅读原文”后的URL
	 *
	 * @param contentSourceUrl 图文消息的原文地址，即点击“阅读原文”后的URL
	 */
	public void setContentSourceUrl( String contentSourceUrl ) {
		this.contentSourceUrl = contentSourceUrl;
	}


	public Integer getOrderNum() {
		return orderNum;
	}


	public void setOrderNum( Integer orderNum ) {
		this.orderNum = orderNum;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", myMediaId=").append(myMediaId);
		sb.append(", title=").append(title);
		sb.append(", thumbMediaId=").append(thumbMediaId);
		sb.append(", thumbUrl=").append(thumbUrl);
		sb.append(", showCoverPic=").append(showCoverPic);
		sb.append(", author=").append(author);
		sb.append(", digest=").append(digest);
		sb.append(", content=").append(content);
		sb.append(", url=").append(url);
		sb.append(", contentSourceUrl=").append(contentSourceUrl);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
