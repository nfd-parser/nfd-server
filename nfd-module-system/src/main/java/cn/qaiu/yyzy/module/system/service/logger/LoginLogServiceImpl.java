package cn.qaiu.yyzy.module.system.service.logger;

import cn.qaiu.yyzy.framework.common.pojo.PageResult;
import cn.qaiu.yyzy.framework.common.util.object.BeanUtils;
import cn.qaiu.yyzy.module.system.api.logger.dto.LoginLogCreateReqDTO;
import cn.qaiu.yyzy.module.system.controller.admin.logger.vo.loginlog.LoginLogPageReqVO;
import cn.qaiu.yyzy.module.system.dal.dataobject.logger.LoginLogDO;
import cn.qaiu.yyzy.module.system.dal.mysql.logger.LoginLogMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * 登录日志 Service 实现
 */
@Service
@Validated
public class LoginLogServiceImpl implements LoginLogService {

    @Resource
    private LoginLogMapper loginLogMapper;

    @Override
    public PageResult<LoginLogDO> getLoginLogPage(LoginLogPageReqVO pageReqVO) {
        return loginLogMapper.selectPage(pageReqVO);
    }

    @Override
    public void createLoginLog(LoginLogCreateReqDTO reqDTO) {
        LoginLogDO loginLog = BeanUtils.toBean(reqDTO, LoginLogDO.class);
        loginLogMapper.insert(loginLog);
    }

}
