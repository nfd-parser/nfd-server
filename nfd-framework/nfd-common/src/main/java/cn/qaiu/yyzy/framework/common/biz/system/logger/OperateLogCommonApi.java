package cn.qaiu.yyzy.framework.common.biz.system.logger;

import cn.qaiu.yyzy.framework.common.biz.system.logger.dto.OperateLogCreateReqDTO;
import org.springframework.scheduling.annotation.Async;

import javax.validation.Valid;

/**
 * 操作日志 API 接口
 *
 * @author 芋道源码
 */
public interface OperateLogCommonApi {

    /**
     * 创建操作日志
     *
     * @param createReqDTO 请求
     */
    void createOperateLog(@Valid OperateLogCreateReqDTO createReqDTO);

    /**
     * 【异步】创建操作日志
     *
     * @param createReqDTO 请求
     */
    @Async
    default void createOperateLogAsync(OperateLogCreateReqDTO createReqDTO) {
        createOperateLog(createReqDTO);
    }

}
