package site.lovecode.wechat.annotation;

import java.lang.annotation.*;

/**
 * 标示语句是查询语句
 * <p>
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Read {
	//String vaule() default "read";
}
