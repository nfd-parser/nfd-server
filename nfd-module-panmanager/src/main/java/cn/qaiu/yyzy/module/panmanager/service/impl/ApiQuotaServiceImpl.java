package cn.qaiu.yyzy.module.panmanager.service.impl;

import cn.qaiu.yyzy.module.panmanager.dal.dataobject.ApiQuotaDO;
import cn.qaiu.yyzy.module.panmanager.dal.mysql.ApiQuotaMapper;
import cn.qaiu.yyzy.module.panmanager.service.ApiQuotaService;
import cn.qaiu.yyzy.module.panmanager.controller.admin.apiquota.vo.*;
import cn.qaiu.yyzy.module.panmanager.convert.ApiQuotaConvert;
import cn.qaiu.yyzy.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApiQuotaServiceImpl implements ApiQuotaService {
    @Autowired
    private ApiQuotaMapper mapper;
    @Autowired
    private ApiQuotaConvert convert;

    @Override
    public Integer create(ApiQuotaSaveReqVO reqVO) {
        ApiQuotaDO entity = convert.convert(reqVO);
        entity.setLastUpdate(new Date());
        mapper.insert(entity);
        return entity.getId();
    }

    @Override
    public Boolean update(ApiQuotaSaveReqVO reqVO) {
        ApiQuotaDO entity = convert.convert(reqVO);
        entity.setLastUpdate(new Date());
        return mapper.updateById(entity) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return mapper.deleteById(id) > 0;
    }

    @Override
    public ApiQuotaRespVO get(Integer id) {
        ApiQuotaDO entity = mapper.selectById(id);
        return convert.convert(entity);
    }

    @Override
    public PageResult<ApiQuotaRespVO> page(ApiQuotaPageReqVO pageReqVO) {
        LambdaQueryWrapper<ApiQuotaDO> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(pageReqVO.getTarget())) wrapper.eq(ApiQuotaDO::getTarget, pageReqVO.getTarget());
        if (pageReqVO.getIsIp() != null) wrapper.eq(ApiQuotaDO::getIsIp, pageReqVO.getIsIp());
        Page<ApiQuotaDO> page = new Page<>(pageReqVO.getPageNo(), pageReqVO.getPageSize());
        Page<ApiQuotaDO> result = mapper.selectPage(page, wrapper);
        List<ApiQuotaRespVO> list = convert.convertList(result.getRecords());
        return new PageResult<>(list, result.getTotal());
    }
} 