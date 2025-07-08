package cn.qaiu.yyzy.module.panmanager.service;

import cn.qaiu.yyzy.module.panmanager.controller.admin.apistatisticsinfo.vo.ApiStatisticsInfoReqVO;
import cn.qaiu.yyzy.module.panmanager.controller.admin.apistatisticsinfo.vo.ApiStatisticsInfoRespVO;
import cn.qaiu.yyzy.module.panmanager.controller.admin.apistatisticsinfo.vo.ApiStatisticsInfoSaveReqVO;
import cn.qaiu.yyzy.module.panmanager.dal.dataobject.ApiStatisticsInfoDO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.validation.Valid;

public interface ApiStatisticsInfoService extends IService<ApiStatisticsInfoDO> {
    Long createApiStatisticsInfo(@Valid ApiStatisticsInfoSaveReqVO createReqVO);
    void updateApiStatisticsInfo(@Valid ApiStatisticsInfoSaveReqVO updateReqVO);
    void deleteApiStatisticsInfo(String shareKey);
    ApiStatisticsInfoRespVO getApiStatisticsInfo(String shareKey);
    IPage<ApiStatisticsInfoRespVO> getApiStatisticsInfoPage(ApiStatisticsInfoReqVO pageReqVO);
} 