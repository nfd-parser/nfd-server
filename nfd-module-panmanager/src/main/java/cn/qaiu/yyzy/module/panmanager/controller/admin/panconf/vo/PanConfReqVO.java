package cn.qaiu.yyzy.module.panmanager.controller.admin.panconf.vo;

import cn.qaiu.yyzy.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 网盘配置 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class PanConfReqVO extends PageParam {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "网盘用户", example = "zyy")
    private String panUser;

    @Schema(description = "网盘密码", example = "123456")
    private String panPass;

    @Schema(description = "网盘类型", example = "lz")
    private String panType;

    @Schema(description = "网盘token", example = "j12394jf9897")
    private String panToken;

    @Schema(description = "是否启用", example = "1")
    private Integer enable;

}
