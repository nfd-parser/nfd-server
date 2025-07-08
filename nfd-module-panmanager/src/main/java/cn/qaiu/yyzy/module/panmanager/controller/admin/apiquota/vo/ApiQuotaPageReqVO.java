package cn.qaiu.yyzy.module.panmanager.controller.admin.apiquota.vo;

import cn.qaiu.yyzy.framework.common.pojo.PageParam;
import lombok.Data;

/**
 * API配额分页查询请求 VO
 */
@Data
public class ApiQuotaPageReqVO extends PageParam {
    /** IP地址或域名 */
    private String target;
    /** 是否是IP(1-IP,0-域名) */
    private Boolean isIp;
} 