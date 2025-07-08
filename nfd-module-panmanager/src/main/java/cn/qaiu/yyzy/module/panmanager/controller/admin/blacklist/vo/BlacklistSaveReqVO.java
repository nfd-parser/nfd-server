package cn.qaiu.yyzy.module.panmanager.controller.admin.blacklist.vo;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 黑名单保存请求 VO
 */
@Data
public class BlacklistSaveReqVO {
    /** 记录ID */
    private Integer id;
    /** IP地址或域名 */
    @NotBlank
    private String target;
    /** 是否是IP(1-IP,0-域名) */
    @NotNull
    private Boolean isIp;
    /** 加入黑名单原因 */
    private String reason;
    /** 是否生效(1-是,0-否) */
    @NotNull
    private Boolean isActive;
    /** 拦截次数统计 */
    @NotNull
    private Integer blockCount;
    /** 最后更新时间 */
    private String lastUpdate;
} 