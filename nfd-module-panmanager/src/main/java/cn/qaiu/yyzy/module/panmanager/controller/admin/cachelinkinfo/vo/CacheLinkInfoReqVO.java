package cn.qaiu.yyzy.module.panmanager.controller.admin.cachelinkinfo.vo;

import cn.qaiu.yyzy.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 直链缓存信息 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class CacheLinkInfoReqVO extends PageParam {
    @Schema(description = "分享key", example = "abcdefg")
    private String shareKey;

    @Schema(description = "直链", example = "https://xxx.com/abc")
    private String directLink;

    @Schema(description = "过期时间戳", example = "1710000000000")
    private Long expiration;
} 