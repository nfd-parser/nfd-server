package cn.qaiu.yyzy.module.panmanager.controller.admin.panconf.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Schema(description = "管理后台 - 网盘配置创建/更新 Request VO")
@Data
public class PanConfSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "网盘用户", requiredMode = Schema.RequiredMode.REQUIRED, example = "zyy")
    @NotEmpty(message = "网盘用户不能为空")
    private String panUser;

    @Schema(description = "网盘密码", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456")
    @NotEmpty(message = "网盘密码不能为空")
    private String panPass;

    @Schema(description = "网盘类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "lz")
    @NotEmpty(message = "网盘类型不能为空")
    private String panType;

    @Schema(description = "网盘token", example = "j12394jf9897")
    private String panToken;

    @Schema(description = "是否启用", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "是否启用不能为空")
    private Boolean enable;

} 