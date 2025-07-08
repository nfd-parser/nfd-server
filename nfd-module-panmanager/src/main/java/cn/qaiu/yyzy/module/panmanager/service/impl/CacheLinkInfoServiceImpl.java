package cn.qaiu.yyzy.module.panmanager.service.impl;

import cn.qaiu.yyzy.framework.common.exception.util.ServiceExceptionUtil;
import cn.qaiu.yyzy.module.panmanager.controller.admin.cachelinkinfo.vo.CacheLinkInfoReqVO;
import cn.qaiu.yyzy.module.panmanager.controller.admin.cachelinkinfo.vo.CacheLinkInfoRespVO;
import cn.qaiu.yyzy.module.panmanager.controller.admin.cachelinkinfo.vo.CacheLinkInfoSaveReqVO;
import cn.qaiu.yyzy.module.panmanager.dal.dataobject.CacheLinkInfoDO;
import cn.qaiu.yyzy.module.panmanager.dal.mysql.CacheLinkInfoMapper;
import cn.qaiu.yyzy.module.panmanager.service.CacheLinkInfoService;
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
public class CacheLinkInfoServiceImpl extends ServiceImpl<CacheLinkInfoMapper, CacheLinkInfoDO> implements CacheLinkInfoService {

    @Resource
    private CacheLinkInfoMapper cacheLinkInfoMapper;

    @Override
    public Long createCacheLinkInfo(CacheLinkInfoSaveReqVO createReqVO) {
        CacheLinkInfoDO entity = new CacheLinkInfoDO();
        BeanUtils.copyProperties(createReqVO, entity);
        cacheLinkInfoMapper.insert(entity);
        // 主键为 shareKey
        return null;
    }

    @Override
    public void updateCacheLinkInfo(CacheLinkInfoSaveReqVO updateReqVO) {
        validateCacheLinkInfoExists(updateReqVO.getShareKey());
        CacheLinkInfoDO entity = new CacheLinkInfoDO();
        BeanUtils.copyProperties(updateReqVO, entity);
        cacheLinkInfoMapper.updateById(entity);
    }

    @Override
    public void deleteCacheLinkInfo(String shareKey) {
        validateCacheLinkInfoExists(shareKey);
        cacheLinkInfoMapper.deleteById(shareKey);
    }

    private void validateCacheLinkInfoExists(String shareKey) {
        if (cacheLinkInfoMapper.selectById(shareKey) == null) {
            throw new RuntimeException("直链缓存信息不存在");
        }
    }

    @Override
    public CacheLinkInfoRespVO getCacheLinkInfo(String shareKey) {
        CacheLinkInfoDO entity = cacheLinkInfoMapper.selectById(shareKey);
        if (entity == null) {
            return null;
        }
        CacheLinkInfoRespVO respVO = new CacheLinkInfoRespVO();
        BeanUtils.copyProperties(entity, respVO);
        return respVO;
    }

    @Override
    public IPage<CacheLinkInfoRespVO> getCacheLinkInfoPage(CacheLinkInfoReqVO pageReqVO) {
        Page<CacheLinkInfoDO> pageParam = new Page<>(pageReqVO.getPageNo(), pageReqVO.getPageSize());
        LambdaQueryWrapper<CacheLinkInfoDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(pageReqVO.getShareKey() != null, CacheLinkInfoDO::getShareKey, pageReqVO.getShareKey())
                   .like(pageReqVO.getDirectLink() != null, CacheLinkInfoDO::getDirectLink, pageReqVO.getDirectLink())
                   .orderByDesc(CacheLinkInfoDO::getExpiration);
        Page<CacheLinkInfoDO> doPage = cacheLinkInfoMapper.selectPage(pageParam, queryWrapper);
        return doPage.convert(doObj -> {
            CacheLinkInfoRespVO respVO = new CacheLinkInfoRespVO();
            BeanUtils.copyProperties(doObj, respVO);
            return respVO;
        });
    }
} 