package cn.qaiu.yyzy.module.infra.dal.dataobject.demo.demo01;

import cn.qaiu.yyzy.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sun.xml.bind.v2.TODO;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 示例联系人 DO
 *
 * @author 芋道源码
 */
@TableName("nfd_demo01_contact")
@KeySequence("nfd_demo01_contact_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Demo01ContactDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 名字
     */
    private String name;
    /**
     * 性别
     *
     * 枚举 {@link TODO system_user_sex 对应的类}
     */
    private Integer sex;
    /**
     * 出生年
     */
    private LocalDateTime birthday;
    /**
     * 简介
     */
    private String description;
    /**
     * 头像
     */
    private String avatar;

}