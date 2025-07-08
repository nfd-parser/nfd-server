package cn.qaiu.yyzy.module.panmanager.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * API黑名单表
 */
@Data
@TableName("blacklist")
public class BlacklistDO implements Serializable {
    /** 记录ID */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /** IP地址或域名 */
    private String target;
    /** 是否是IP(1-IP,0-域名) */
    private Boolean isIp;
    /** 加入黑名单原因 */
    private String reason;
    /** 是否生效(1-是,0-否) */
    private Boolean isActive;
    /** 拦截次数统计 */
    private Integer blockCount;
    /** 最后更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date lastUpdate;
} 