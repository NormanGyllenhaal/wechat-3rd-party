package site.lovecode.wechat.annotation;

import java.lang.annotation.*;

/**
 * 标示语句是更新语句
 * <p>
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Write {
	//String vaule() default "write";
	//判断是否从写库查询的条件mvel表达式,结果为boolean型,true从写库查,false从从库查
	String value();
}
