package cn.qaiu.yyzy.module.panmanager.service.impl;

import cn.qaiu.yyzy.framework.common.exception.util.ServiceExceptionUtil;
import cn.qaiu.yyzy.module.panmanager.controller.admin.apistatisticsinfo.vo.ApiStatisticsInfoReqVO;
import cn.qaiu.yyzy.module.panmanager.controller.admin.apistatisticsinfo.vo.ApiStatisticsInfoRespVO;
import cn.qaiu.yyzy.module.panmanager.controller.admin.apistatisticsinfo.vo.ApiStatisticsInfoSaveReqVO;
import cn.qaiu.yyzy.module.panmanager.dal.dataobject.ApiStatisticsInfoDO;
import cn.qaiu.yyzy.module.panmanager.dal.mysql.ApiStatisticsInfoMapper;
import cn.qaiu.yyzy.module.panmanager.service.ApiStatisticsInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

@Service
@Validated
public class ApiStatisticsInfoServiceImpl extends ServiceImpl<ApiStatisticsInfoMapper, ApiStatisticsInfoDO> implements ApiStatisticsInfoService {

    @Resource
    private ApiStatisticsInfoMapper apiStatisticsInfoMapper;

    @Override
    public Long createApiStatisticsInfo(ApiStatisticsInfoSaveReqVO createReqVO) {
        ApiStatisticsInfoDO entity = new ApiStatisticsInfoDO();
        BeanUtils.copyProperties(createReqVO, entity);
        apiStatisticsInfoMapper.insert(entity);
        // 主键为 shareKey
        return null;
    }

    @Override
    public void updateApiStatisticsInfo(ApiStatisticsInfoSaveReqVO updateReqVO) {
        validateApiStatisticsInfoExists(updateReqVO.getShareKey());
        ApiStatisticsInfoDO entity = new ApiStatisticsInfoDO();
        BeanUtils.copyProperties(updateReqVO, entity);
        apiStatisticsInfoMapper.updateById(entity);
    }

    @Override
    public void deleteApiStatisticsInfo(String shareKey) {
        validateApiStatisticsInfoExists(shareKey);
        apiStatisticsInfoMapper.deleteById(shareKey);
    }

    private void validateApiStatisticsInfoExists(String shareKey) {
        if (apiStatisticsInfoMapper.selectById(shareKey) == null) {
            throw new RuntimeException("API统计信息不存在");
        }
    }

    @Override
    public ApiStatisticsInfoRespVO getApiStatisticsInfo(String shareKey) {
        ApiStatisticsInfoDO entity = apiStatisticsInfoMapper.selectById(shareKey);
        if (entity == null) {
            return null;
        }
        ApiStatisticsInfoRespVO respVO = new ApiStatisticsInfoRespVO();
        BeanUtils.copyProperties(entity, respVO);
        return respVO;
    }

    @Override
    public IPage<ApiStatisticsInfoRespVO> getApiStatisticsInfoPage(ApiStatisticsInfoReqVO pageReqVO) {
        Page<ApiStatisticsInfoDO> pageParam = new Page<>(pageReqVO.getPageNo(), pageReqVO.getPageSize());
        LambdaQueryWrapper<ApiStatisticsInfoDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(pageReqVO.getShareKey() != null, ApiStatisticsInfoDO::getShareKey, pageReqVO.getShareKey())
                   .like(pageReqVO.getPanType() != null, ApiStatisticsInfoDO::getPanType, pageReqVO.getPanType())
                   .orderByDesc(ApiStatisticsInfoDO::getUpdateTs);
        Page<ApiStatisticsInfoDO> doPage = apiStatisticsInfoMapper.selectPage(pageParam, queryWrapper);
        return doPage.convert(doObj -> {
            ApiStatisticsInfoRespVO respVO = new ApiStatisticsInfoRespVO();
            BeanUtils.copyProperties(doObj, respVO);
            return respVO;
        });
    }
} 