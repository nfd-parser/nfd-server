package cn.qaiu.yyzy.module.panmanager.service;

import cn.qaiu.yyzy.module.panmanager.controller.admin.cachelinkinfo.vo.CacheLinkInfoReqVO;
import cn.qaiu.yyzy.module.panmanager.controller.admin.cachelinkinfo.vo.CacheLinkInfoRespVO;
import cn.qaiu.yyzy.module.panmanager.controller.admin.cachelinkinfo.vo.CacheLinkInfoSaveReqVO;
import cn.qaiu.yyzy.module.panmanager.dal.dataobject.CacheLinkInfoDO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.validation.Valid;

public interface CacheLinkInfoService extends IService<CacheLinkInfoDO> {
    Long createCacheLinkInfo(@Valid CacheLinkInfoSaveReqVO createReqVO);
    void updateCacheLinkInfo(@Valid CacheLinkInfoSaveReqVO updateReqVO);
    void deleteCacheLinkInfo(String shareKey);
    CacheLinkInfoRespVO getCacheLinkInfo(String shareKey);
    IPage<CacheLinkInfoRespVO> getCacheLinkInfoPage(CacheLinkInfoReqVO pageReqVO);
} 