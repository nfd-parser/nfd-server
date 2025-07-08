package cn.qaiu.yyzy.module.panmanager.service;

import cn.qaiu.yyzy.module.panmanager.controller.admin.apiquota.vo.*;
import cn.qaiu.yyzy.framework.common.pojo.PageResult;

public interface ApiQuotaService {
    Integer create(ApiQuotaSaveReqVO reqVO);
    Boolean update(ApiQuotaSaveReqVO reqVO);
    Boolean delete(Integer id);
    ApiQuotaRespVO get(Integer id);
    PageResult<ApiQuotaRespVO> page(ApiQuotaPageReqVO pageReqVO);
} 