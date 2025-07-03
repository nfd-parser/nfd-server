package cn.qaiu.yyzy.framework.tracer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * BizTracer配置类
 *
 * @author 麻薯
 */
@ConfigurationProperties("nfd.tracer")
@Data
public class TracerProperties {
}
