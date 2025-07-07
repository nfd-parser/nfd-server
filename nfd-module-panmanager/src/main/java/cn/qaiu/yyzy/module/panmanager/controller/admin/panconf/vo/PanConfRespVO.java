package cn.qaiu.yyzy.module.panmanager.controller.admin.panconf.vo;

import cn.qaiu.yyzy.module.panmanager.dal.dataobject.PanConfDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 网盘配置 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class PanConfRespVO extends PanConfDO {



}
