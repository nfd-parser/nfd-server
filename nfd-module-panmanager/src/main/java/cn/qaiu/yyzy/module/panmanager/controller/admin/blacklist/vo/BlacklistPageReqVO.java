package cn.qaiu.yyzy.module.panmanager.controller.admin.blacklist.vo;

import cn.qaiu.yyzy.framework.common.pojo.PageParam;
import lombok.Data;

/**
 * 黑名单分页查询请求 VO
 */
@Data
public class BlacklistPageReqVO extends PageParam {
    /** IP地址或域名 */
    private String target;
    /** 是否是IP(1-IP,0-域名) */
    private Boolean isIp;
    /** 是否生效(1-是,0-否) */
    private Boolean isActive;
} 