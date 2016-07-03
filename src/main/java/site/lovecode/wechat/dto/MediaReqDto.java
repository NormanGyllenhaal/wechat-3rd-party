/**
 * MediaReqDto.java site.lovecode.wechat.dto Copyright (c)
 * 2016,norman.
 */
/**
 * MediaReqDto.java site.lovecode.wechat.dto Copyright (c)
 * 2016,norman.
 */


package site.lovecode.wechat.dto;

import java.io.File;


/**
 * 视频参数
 * <p>
 * TODO(这里描述这个类补充说明 – 可选)
 *
 * @author   Administrator
 * @date	 2016年5月18日 
 * @version  1.0.0	 
 */
public class MediaReqDto {


	/**
	 * 机构参数
	 */
	private Long orgId;


	/**
	 * 文件对象
	 */
	private File file;

	/**
	 * 文件名
	 */
	private String name;

	/**
	 * 文件路径
	 */
	private String filePath;

	/**
	 * 视频名称
	 */
	private String videoTitle;

	/**
	 * 视频介绍
	 */
	private String videoIntroduction;


	public Long getOrgId() {
		return orgId;
	}


	public void setOrgId( Long orgId ) {
		this.orgId = orgId;
	}


	public File getFile() {
		return file;
	}


	public void setFile( File file ) {
		this.file = file;
	}


	public String getName() {
		return name;
	}


	public void setName( String name ) {
		this.name = name;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath( String filePath ) {
		this.filePath = filePath;
	}


	public String getVideoTitle() {
		return videoTitle;
	}


	public void setVideoTitle( String videoTitle ) {
		this.videoTitle = videoTitle;
	}


	public String getVideoIntroduction() {
		return videoIntroduction;
	}


	public void setVideoIntroduction( String videoIntroduction ) {
		this.videoIntroduction = videoIntroduction;
	}


}
