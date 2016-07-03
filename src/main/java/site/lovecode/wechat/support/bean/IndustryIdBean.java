package site.lovecode.wechat.support.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Administrator on 2016/4/28.
 */
public class IndustryIdBean {

	@JSONField( name = "industry_id1" )
	private Integer industry1;

	@JSONField( name = "industry_id2" )
	private Integer industry2;


	public Integer getIndustry1() {
		return industry1;
	}


	public void setIndustry1( Integer industry1 ) {
		this.industry1 = industry1;
	}


	public Integer getIndustry2() {
		return industry2;
	}


	public void setIndustry2( Integer industry2 ) {
		this.industry2 = industry2;
	}
}
