package cn.qaiu.yyzy.module.panmanager.controller.admin.apiquota.vo;

import lombok.Data;
import java.util.Date;

/**
 * API配额返回 VO
 */
@Data
public class ApiQuotaRespVO {
    /** 记录ID */
    private Integer id;
    /** IP地址或域名 */
    private String target;
    /** 是否是IP(1-IP,0-域名) */
    private Boolean isIp;
    /** 总可用次数 */
    private Integer totalQuota;
    /** 剩余可用次数 */
    private Integer remaining;
    /** 最后更新时间 */
    private Date lastUpdate;
} 