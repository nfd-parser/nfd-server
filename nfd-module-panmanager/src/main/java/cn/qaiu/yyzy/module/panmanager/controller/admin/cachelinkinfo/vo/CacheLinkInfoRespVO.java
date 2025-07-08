package cn.qaiu.yyzy.module.panmanager.controller.admin.cachelinkinfo.vo;

import cn.qaiu.yyzy.module.panmanager.dal.dataobject.CacheLinkInfoDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 直链缓存信息 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class CacheLinkInfoRespVO extends CacheLinkInfoDO {
} 