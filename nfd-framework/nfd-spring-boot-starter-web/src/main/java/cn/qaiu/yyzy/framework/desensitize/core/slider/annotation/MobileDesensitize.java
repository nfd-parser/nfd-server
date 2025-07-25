package cn.qaiu.yyzy.framework.desensitize.core.slider.annotation;

import cn.qaiu.yyzy.framework.desensitize.core.base.annotation.DesensitizeBy;
import cn.qaiu.yyzy.framework.desensitize.core.slider.handler.MobileDesensitization;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;

import java.lang.annotation.*;

/**
 * 手机号
 *
 * @author gaibu
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@DesensitizeBy(handler = MobileDesensitization.class)
public @interface MobileDesensitize {

    /**
     * 前缀保留长度
     */
    int prefixKeep() default 3;

    /**
     * 后缀保留长度
     */
    int suffixKeep() default 4;

    /**
     * 替换规则，手机号;比如：13248765917 脱敏之后为 132****5917
     */
    String replacer() default "*";

    /**
     * 是否禁用脱敏
     *
     * 支持 Spring EL 表达式，如果返回 true 则跳过脱敏
     */
    String disable() default "";

}
