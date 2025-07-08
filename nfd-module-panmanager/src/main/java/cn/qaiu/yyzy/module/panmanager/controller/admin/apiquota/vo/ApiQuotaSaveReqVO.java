package cn.qaiu.yyzy.module.panmanager.controller.admin.apiquota.vo;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * API配额保存请求 VO
 */
@Data
public class ApiQuotaSaveReqVO {
    /** 记录ID */
    private Integer id;
    /** IP地址或域名 */
    @NotBlank
    private String target;
    /** 是否是IP(1-IP,0-域名) */
    @NotNull
    private Boolean isIp;
    /** 总可用次数 */
    @NotNull
    private Integer totalQuota;
    /** 剩余可用次数 */
    @NotNull
    private Integer remaining;
} 