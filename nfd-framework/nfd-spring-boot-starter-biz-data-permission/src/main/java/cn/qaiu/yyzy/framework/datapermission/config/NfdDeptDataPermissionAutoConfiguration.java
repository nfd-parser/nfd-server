package cn.qaiu.yyzy.framework.datapermission.config;

import cn.qaiu.yyzy.framework.common.biz.system.permission.PermissionCommonApi;
import cn.qaiu.yyzy.framework.datapermission.core.rule.dept.DeptDataPermissionRule;
import cn.qaiu.yyzy.framework.datapermission.core.rule.dept.DeptDataPermissionRuleCustomizer;
import cn.qaiu.yyzy.framework.security.core.LoginUser;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * 基于部门的数据权限 AutoConfiguration
 *
 * @author 芋道源码
 */
@AutoConfiguration
@ConditionalOnClass(LoginUser.class)
@ConditionalOnBean(value = {PermissionCommonApi.class, DeptDataPermissionRuleCustomizer.class})
public class NfdDeptDataPermissionAutoConfiguration {

    @Bean
    public DeptDataPermissionRule deptDataPermissionRule(PermissionCommonApi permissionApi,
                                                         List<DeptDataPermissionRuleCustomizer> customizers) {
        // 创建 DeptDataPermissionRule 对象
        DeptDataPermissionRule rule = new DeptDataPermissionRule(permissionApi);
        // 补全表配置
        customizers.forEach(customizer -> customizer.customize(rule));
        return rule;
    }

}
