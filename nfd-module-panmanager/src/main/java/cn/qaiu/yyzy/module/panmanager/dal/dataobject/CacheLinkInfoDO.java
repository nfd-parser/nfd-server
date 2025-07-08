package cn.qaiu.yyzy.module.panmanager.dal.dataobject;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "直链缓存信息 DO")
@TableName("cache_link_info")
@Data
public class CacheLinkInfoDO {
    @Schema(description = "分享key", example = "abcdefg")
    @TableId
    private String shareKey;

    @Schema(description = "直链", example = "https://xxx.com/abc")
    private String directLink;

    @Schema(description = "过期时间戳", example = "1710000000000")
    private Long expiration;
} 