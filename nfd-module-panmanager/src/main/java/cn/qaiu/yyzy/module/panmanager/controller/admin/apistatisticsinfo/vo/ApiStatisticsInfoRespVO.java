package cn.qaiu.yyzy.module.panmanager.controller.admin.apistatisticsinfo.vo;

import cn.qaiu.yyzy.module.panmanager.dal.dataobject.ApiStatisticsInfoDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - API统计信息 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class ApiStatisticsInfoRespVO extends ApiStatisticsInfoDO {
} 