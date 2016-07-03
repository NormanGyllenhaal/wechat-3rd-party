package site.lovecode.wechat.support.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Administrator on 2016/4/28.
 */
public class IndustryBean {

	@JSONField( name = "primary_industry" )
	private Industry primaryIndustry;

	@JSONField( name = "secondary_industry" )
	private Industry secondaryIndustry;


	public Industry getPrimaryIndustry() {
		return primaryIndustry;
	}


	public void setPrimaryIndustry( Industry primaryIndustry ) {
		this.primaryIndustry = primaryIndustry;
	}


	public Industry getSecondaryIndustry() {
		return secondaryIndustry;
	}


	public void setSecondaryIndustry( Industry secondaryIndustry ) {
		this.secondaryIndustry = secondaryIndustry;
	}

	public static class Industry {

		@JSONField( name = "first_class" )
		private String firstClass;

		@JSONField( name = "second_class" )
		private String secondClass;


		public String getFirstClass() {
			return firstClass;
		}


		public void setFirstClass( String firstClass ) {
			this.firstClass = firstClass;
		}


		public String getSecondClass() {
			return secondClass;
		}


		public void setSecondClass( String secondClass ) {
			this.secondClass = secondClass;
		}
	}


}
