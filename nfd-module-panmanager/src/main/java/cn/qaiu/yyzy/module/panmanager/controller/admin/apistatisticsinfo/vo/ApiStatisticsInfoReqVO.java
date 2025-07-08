package cn.qaiu.yyzy.module.panmanager.controller.admin.apistatisticsinfo.vo;

import cn.qaiu.yyzy.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - API统计信息 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class ApiStatisticsInfoReqVO extends PageParam {
    @Schema(description = "网盘类型标识（如lz）", example = "lz")
    private String panType;

    @Schema(description = "资源分享链接的唯一标识（主键）", example = "abcdefg")
    private String shareKey;

    @Schema(description = "缓存命中总次数", example = "10")
    private Integer cacheHitTotal;

    @Schema(description = "API解析调用总次数", example = "20")
    private Integer apiParserTotal;

    @Schema(description = "最后更新时间", example = "1710000000000")
    private Long updateTs;
} 