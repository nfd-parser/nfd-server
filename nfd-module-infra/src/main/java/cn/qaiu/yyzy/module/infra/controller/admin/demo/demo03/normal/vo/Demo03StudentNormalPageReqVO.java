package cn.qaiu.yyzy.module.infra.controller.admin.demo.demo03.normal.vo;

import cn.qaiu.yyzy.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.qaiu.yyzy.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 学生分页 Request VO")
@Data
public class Demo03StudentNormalPageReqVO extends PageParam {

    @Schema(description = "名字", example = "芋艿")
    private String name;

    @Schema(description = "性别")
    private Integer sex;

    @Schema(description = "简介", example = "随便")
    private String description;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}