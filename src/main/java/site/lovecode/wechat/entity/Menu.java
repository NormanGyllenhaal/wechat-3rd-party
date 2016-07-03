package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table( name = "WX_MENU" )
public class Menu implements Identity, Serializable {

	@Id
	private Long id;

	/**
	 * 公众号id
	 */
	private Long officialAccountId;

	/**
	 * 公众号菜单的类型，公众平台官网上能够设置的菜单类型有view（跳转网页）、text（返回文本，下同）、img、photo、video、voice。使用API设置的则有8种
	 */
	private Integer type;

	/**
	 * 菜单名称
	 */
	private String name;

	/**
	 * 对于不同的菜单类型，value的值意义不同。官网上设置的自定义菜单：
	        Text:保存文字到value； Img、voice：保存mediaID到value； Video：保存视频下载链接到value； News：保存图文消息到news_info，同时保存mediaID到value； View：保存链接到url
	 */
	private String value;

	/**
	 * 使用API设置的自定义菜单： click、scancode_push、scancode_waitmsg、pic_sysphoto、pic_photo_or_album、	pic_weixin、location_select：保存值到key；view：保存链接到url
	 */
	private String menuKey;

	private String url;

	/**
	 * 菜单级别 一级或二级
	 */
	private Integer level;

	/**
	 * 父菜单id,关联本表主键
	 */
	private Long parentId;

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
	 * 获取公众号id
	 *
	 * @return officialAccountId - 公众号id
	 */
	public Long getOfficialAccountId() {
		return officialAccountId;
	}


	/**
	 * 设置公众号id
	 *
	 * @param officialAccountId 公众号id
	 */
	public void setOfficialAccountId( Long officialAccountId ) {
		this.officialAccountId = officialAccountId;
	}


	/**
	 * 获取公众号菜单的类型，公众平台官网上能够设置的菜单类型有view（跳转网页）、text（返回文本，下同）、img、photo、video、voice。使用API设置的则有8种
	 *
	 * @return type - 公众号菜单的类型，公众平台官网上能够设置的菜单类型有view（跳转网页）、text（返回文本，下同）、img、photo、video、voice。使用API设置的则有8种
	 */
	public Integer getType() {
		return type;
	}


	/**
	 * 设置公众号菜单的类型，公众平台官网上能够设置的菜单类型有view（跳转网页）、text（返回文本，下同）、img、photo、video、voice。使用API设置的则有8种
	 *
	 * @param type 公众号菜单的类型，公众平台官网上能够设置的菜单类型有view（跳转网页）、text（返回文本，下同）、img、photo、video、voice。使用API设置的则有8种
	 */
	public void setType( Integer type ) {
		this.type = type;
	}


	/**
	 * 获取菜单名称
	 *
	 * @return name - 菜单名称
	 */
	public String getName() {
		return name;
	}


	/**
	 * 设置菜单名称
	 *
	 * @param name 菜单名称
	 */
	public void setName( String name ) {
		this.name = name;
	}


	/**
	 * 获取对于不同的菜单类型，value的值意义不同。官网上设置的自定义菜单：
	        Text:保存文字到value； Img、voice：保存mediaID到value； Video：保存视频下载链接到value； News：保存图文消息到news_info，同时保存mediaID到value； View：保存链接到url
	 *
	 * @return value - 对于不同的菜单类型，value的值意义不同。官网上设置的自定义菜单：
	        Text:保存文字到value； Img、voice：保存mediaID到value； Video：保存视频下载链接到value； News：保存图文消息到news_info，同时保存mediaID到value； View：保存链接到url
	 */
	public String getValue() {
		return value;
	}


	/**
	 * 设置对于不同的菜单类型，value的值意义不同。官网上设置的自定义菜单：
	        Text:保存文字到value； Img、voice：保存mediaID到value； Video：保存视频下载链接到value； News：保存图文消息到news_info，同时保存mediaID到value； View：保存链接到url
	 *
	 * @param value 对于不同的菜单类型，value的值意义不同。官网上设置的自定义菜单：
	        Text:保存文字到value； Img、voice：保存mediaID到value； Video：保存视频下载链接到value； News：保存图文消息到news_info，同时保存mediaID到value； View：保存链接到url
	 */
	public void setValue( String value ) {
		this.value = value;
	}


	/**
	 * 获取使用API设置的自定义菜单： click、scancode_push、scancode_waitmsg、pic_sysphoto、pic_photo_or_album、	pic_weixin、location_select：保存值到key；view：保存链接到url
	 *
	 * @return menuKey - 使用API设置的自定义菜单： click、scancode_push、scancode_waitmsg、pic_sysphoto、pic_photo_or_album、	pic_weixin、location_select：保存值到key；view：保存链接到url
	 */
	public String getMenuKey() {
		return menuKey;
	}


	/**
	 * 设置使用API设置的自定义菜单： click、scancode_push、scancode_waitmsg、pic_sysphoto、pic_photo_or_album、	pic_weixin、location_select：保存值到key；view：保存链接到url
	 *
	 * @param menuKey 使用API设置的自定义菜单： click、scancode_push、scancode_waitmsg、pic_sysphoto、pic_photo_or_album、	pic_weixin、location_select：保存值到key；view：保存链接到url
	 */
	public void setMenuKey( String menuKey ) {
		this.menuKey = menuKey;
	}


	/**
	 * @return url
	 */
	public String getUrl() {
		return url;
	}


	/**
	 * @param url
	 */
	public void setUrl( String url ) {
		this.url = url;
	}


	/**
	 * 获取菜单级别 一级或二级
	 *
	 * @return level - 菜单级别 一级或二级
	 */
	public Integer getLevel() {
		return level;
	}


	/**
	 * 设置菜单级别 一级或二级
	 *
	 * @param level 菜单级别 一级或二级
	 */
	public void setLevel( Integer level ) {
		this.level = level;
	}


	/**
	 * 获取父菜单id,关联本表主键
	 *
	 * @return parentId - 父菜单id,关联本表主键
	 */
	public Long getParentId() {
		return parentId;
	}


	/**
	 * 设置父菜单id,关联本表主键
	 *
	 * @param parentId 父菜单id,关联本表主键
	 */
	public void setParentId( Long parentId ) {
		this.parentId = parentId;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", officialAccountId=").append(officialAccountId);
		sb.append(", type=").append(type);
		sb.append(", name=").append(name);
		sb.append(", value=").append(value);
		sb.append(", menuKey=").append(menuKey);
		sb.append(", url=").append(url);
		sb.append(", level=").append(level);
		sb.append(", parentId=").append(parentId);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
