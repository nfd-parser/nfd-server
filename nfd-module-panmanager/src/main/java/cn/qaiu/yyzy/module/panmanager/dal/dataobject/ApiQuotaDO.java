package cn.qaiu.yyzy.module.panmanager.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * API调用配额表
 */
@Data
@TableName("api_quota")
public class ApiQuotaDO implements Serializable {
    /** 记录ID */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /** IP地址或域名 */
    private String target;
    /** 是否是IP(1-IP,0-域名) */
    private Boolean isIp;
    /** 总可用次数 */
    private Integer totalQuota;
    /** 剩余可用次数 */
    private Integer remaining;
    /** 最后更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date lastUpdate;
} 