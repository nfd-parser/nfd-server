package cn.qaiu.yyzy.module.system.controller.admin.user.vo.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 用户 Excel 导入 VO
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = false) // 设置 chain = false，避免用户导入有问题
public class UserImportExcelVO {

    private String username;

    private String nickname;

    private Long deptId;

    private String email;

    private String mobile;

    private Integer sex;

    private Integer status;

}
