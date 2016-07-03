package site.lovecode.wechat.annotation;

import java.io.Serializable;
import java.lang.annotation.*;

/**
 * 通用操作注解
 * <p>
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface TableName {

	//表名称
	String table();


	//主键名称,默认id
	String id() default "id";


	//映射的实体名称
	Class<? extends Serializable> entity();
}
