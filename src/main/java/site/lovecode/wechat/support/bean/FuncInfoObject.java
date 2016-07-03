package site.lovecode.wechat.support.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Administrator on 2016/4/6.
 */
public class FuncInfoObject {

	@JSONField( name = "funcscope_category" )
	private IdBean funcscopeCategory;


	public IdBean getFuncscopeCategory() {
		return funcscopeCategory;
	}


	public void setFuncscopeCategory( IdBean funcscopeCategory ) {
		this.funcscopeCategory = funcscopeCategory;
	}


	@Override
	public String toString() {
		return "FuncInfoObject{" + "funcscopeCategory=" + funcscopeCategory + '}';
	}


}
