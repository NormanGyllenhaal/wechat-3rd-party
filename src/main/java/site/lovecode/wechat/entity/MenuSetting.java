package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table( name = "WX_MENU_SETTING" )
public class MenuSetting implements Identity, Serializable {

	@Id
	private Long id;

	/**
	 * 公众号id
	 */
	private Long officialAccountId;

	/**
	 * 菜单是否开启，0代表未开启，1代表开启
	 */
	private Integer isMenuOpen;

	/**
	 * 创建时间
	 */
	private Date createTime;

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
	 * 获取菜单是否开启，0代表未开启，1代表开启
	 *
	 * @return isMenuOpen - 菜单是否开启，0代表未开启，1代表开启
	 */
	public Integer getIsMenuOpen() {
		return isMenuOpen;
	}


	/**
	 * 设置菜单是否开启，0代表未开启，1代表开启
	 *
	 * @param isMenuOpen 菜单是否开启，0代表未开启，1代表开启
	 */
	public void setIsMenuOpen( Integer isMenuOpen ) {
		this.isMenuOpen = isMenuOpen;
	}


	/**
	 * 获取创建时间
	 *
	 * @return createTime - 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}


	/**
	 * 设置创建时间
	 *
	 * @param createTime 创建时间
	 */
	public void setCreateTime( Date createTime ) {
		this.createTime = createTime;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", officialAccountId=").append(officialAccountId);
		sb.append(", isMenuOpen=").append(isMenuOpen);
		sb.append(", createTime=").append(createTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
