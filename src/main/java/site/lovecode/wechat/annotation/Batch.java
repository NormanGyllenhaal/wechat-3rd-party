package site.lovecode.wechat.annotation;

import java.lang.annotation.*;

/**
 * 标示语句是批处理语句
 * <p>
 */
@Target( { ElementType.METHOD } )
@Retention( RetentionPolicy.RUNTIME )
@Inherited
@Documented
public @interface Batch {}
