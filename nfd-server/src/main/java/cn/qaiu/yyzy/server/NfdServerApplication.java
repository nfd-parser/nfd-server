package cn.qaiu.yyzy.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

/**
 * 项目的启动类
 *
 * @author 芋道源码
 */
@SuppressWarnings("SpringComponentScan") // 忽略 IDEA 无法识别 ${nfd.info.base-package}
@SpringBootApplication(scanBasePackages = {"${nfd.info.base-package}.server", "${nfd.info.base-package}.module"})
public class NfdServerApplication {

    public static void main(String[] args) {

        // 强制设置 JVM 时区为东八区
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));

        SpringApplication.run(NfdServerApplication.class, args);
    }

}
