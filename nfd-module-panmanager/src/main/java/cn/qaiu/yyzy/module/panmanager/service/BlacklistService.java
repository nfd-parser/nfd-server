package cn.qaiu.yyzy.module.panmanager.service;

import cn.qaiu.yyzy.module.panmanager.controller.admin.blacklist.vo.*;
import cn.qaiu.yyzy.framework.common.pojo.PageResult;

public interface BlacklistService {
    Integer create(BlacklistSaveReqVO reqVO);
    Boolean update(BlacklistSaveReqVO reqVO);
    Boolean delete(Integer id);
    BlacklistRespVO get(Integer id);
    PageResult<BlacklistRespVO> page(BlacklistPageReqVO pageReqVO);
} 