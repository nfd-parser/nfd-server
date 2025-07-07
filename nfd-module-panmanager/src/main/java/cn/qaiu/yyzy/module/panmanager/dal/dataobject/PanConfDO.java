package cn.qaiu.yyzy.module.panmanager.dal.dataobject;

import cn.qaiu.yyzy.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "网盘配置 DO")
@TableName("pan_conf")
@Data
@ToString(callSuper = true)
public class PanConfDO {

    @Schema(description = "编号", example = "1024")
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 网盘用户
     */
    @Schema(description = "网盘用户", example = "zyy")
    private String panUser;

    /**
     * 网盘密码
     */
    @Schema(description = "网盘密码", example = "123456")
    private String panPass;

    /**
     * 网盘类型 例: lz
     */
    @Schema(description = "网盘类型", example = "lz")
    private String panType;

    /**
     * 网盘token
     */
    @Schema(description = "网盘token", example = "j12394jf9897")
    private String panToken;

    /**
     * 是否启用 0: 禁用 1: 启用
     */
    @Schema(description = "是否启用", example = "1")
    private Boolean enable;

}
