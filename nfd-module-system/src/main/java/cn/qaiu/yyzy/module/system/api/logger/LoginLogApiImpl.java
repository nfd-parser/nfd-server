package cn.qaiu.yyzy.module.system.api.logger;

import cn.qaiu.yyzy.module.system.api.logger.dto.LoginLogCreateReqDTO;
import cn.qaiu.yyzy.module.system.service.logger.LoginLogService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * 登录日志的 API 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class LoginLogApiImpl implements LoginLogApi {

    @Resource
    private LoginLogService loginLogService;

    @Override
    public void createLoginLog(LoginLogCreateReqDTO reqDTO) {
        loginLogService.createLoginLog(reqDTO);
    }

}
