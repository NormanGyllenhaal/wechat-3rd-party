package site.lovecode.wechat.support.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by Administrator on 2016/4/28.
 */
public class TemplateListBean {


	/**
	 * template_id : iPk5sOIt5X_flOVKn5GrTFpncEYTojx6ddbt8WYoV5s
	 * title : 领取奖金提醒
	 * primary_industry : IT科技
	 * deputy_industry : 互联网|电子商务
	 * content : { {result.DATA} }

	 领奖金额:{ {withdrawMoney.DATA} }
	 领奖  时间:{ {withdrawTime.DATA} }
	 银行信息:{ {cardInfo.DATA} }
	 到账时间:  { {arrivedTime.DATA} }
	 { {remark.DATA} }
	 * example : 您已提交领奖申请

	 领奖金额：xxxx元
	 领奖时间：2013-10-10 12:22:22
	 银行信息：xx银行(尾号xxxx)
	 到账时间：预计xxxxxxx

	 预计将于xxxx到达您的银行卡
	 */

	@JSONField( name = "template_list" )
	private List<TemplateBean> templateList;


	public List<TemplateBean> getTemplateList() {
		return templateList;
	}


	public void setTemplateList( List<TemplateBean> templateList ) {
		this.templateList = templateList;
	}

	public static class TemplateBean {

		@JSONField( name = "template_id" )
		private String templateId;

		@JSONField( name = "title" )
		private String title;

		@JSONField( name = "primary_industry" )
		private String primaryIndustry;

		@JSONField( name = "deputy_industry" )
		private String deputyIndustry;

		@JSONField( name = "content" )
		private String content;

		@JSONField( name = "example" )
		private String example;


		public String getTemplateId() {
			return templateId;
		}


		public void setTemplateId( String templateId ) {
			this.templateId = templateId;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle( String title ) {
			this.title = title;
		}


		public String getPrimaryIndustry() {
			return primaryIndustry;
		}


		public void setPrimaryIndustry( String primaryIndustry ) {
			this.primaryIndustry = primaryIndustry;
		}


		public String getDeputyIndustry() {
			return deputyIndustry;
		}


		public void setDeputyIndustry( String deputyIndustry ) {
			this.deputyIndustry = deputyIndustry;
		}


		public String getContent() {
			return content;
		}


		public void setContent( String content ) {
			this.content = content;
		}


		public String getExample() {
			return example;
		}


		public void setExample( String example ) {
			this.example = example;
		}
	}
}
