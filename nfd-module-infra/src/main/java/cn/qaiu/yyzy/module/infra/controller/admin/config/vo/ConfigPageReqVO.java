package cn.qaiu.yyzy.module.infra.controller.admin.config.vo;

import cn.qaiu.yyzy.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.qaiu.yyzy.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 参数配置分页 Request VO")
@Data
public class ConfigPageReqVO extends PageParam {

    @Schema(description = "数据源名称，模糊匹配", example = "名称")
    private String name;

    @Schema(description = "参数键名，模糊匹配", example = "yunai.db.username")
    private String key;

    @Schema(description = "参数类型，参见 SysConfigTypeEnum 枚举", example = "1")
    private Integer type;

    @Schema(description = "创建时间", example = "[2022-07-01 00:00:00,2022-07-01 23:59:59]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
