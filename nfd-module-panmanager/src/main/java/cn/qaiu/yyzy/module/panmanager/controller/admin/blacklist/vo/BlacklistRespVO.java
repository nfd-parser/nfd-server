package cn.qaiu.yyzy.module.panmanager.controller.admin.blacklist.vo;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 黑名单返回 VO
 */
@Data
public class BlacklistRespVO {
    /** 记录ID */
    private Integer id;
    /** IP地址或域名 */
    private String target;
    /** 是否是IP(1-IP,0-域名) */
    private Boolean isIp;
    /** 加入黑名单原因 */
    private String reason;
    /** 是否生效(1-是,0-否) */
    private Boolean isActive;
    /** 拦截次数统计 */
    private Integer blockCount;
    /** 最后更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date lastUpdate;
} 