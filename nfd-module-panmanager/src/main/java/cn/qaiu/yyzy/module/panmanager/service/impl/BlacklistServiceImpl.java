package cn.qaiu.yyzy.module.panmanager.service.impl;

import cn.qaiu.yyzy.module.panmanager.dal.dataobject.BlacklistDO;
import cn.qaiu.yyzy.module.panmanager.dal.mysql.BlacklistMapper;
import cn.qaiu.yyzy.module.panmanager.service.BlacklistService;
import cn.qaiu.yyzy.module.panmanager.controller.admin.blacklist.vo.*;
import cn.qaiu.yyzy.module.panmanager.convert.BlacklistConvert;
import cn.qaiu.yyzy.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlacklistServiceImpl implements BlacklistService {
    @Autowired
    private BlacklistMapper mapper;
    @Autowired
    private BlacklistConvert convert;

    @Override
    public Integer create(BlacklistSaveReqVO reqVO) {
        BlacklistDO entity = convert.convert(reqVO);
        mapper.insert(entity);
        return entity.getId();
    }

    @Override
    public Boolean update(BlacklistSaveReqVO reqVO) {
        BlacklistDO entity = convert.convert(reqVO);
        return mapper.updateById(entity) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return mapper.deleteById(id) > 0;
    }

    @Override
    public BlacklistRespVO get(Integer id) {
        BlacklistDO entity = mapper.selectById(id);
        return convert.convert(entity);
    }

    @Override
    public PageResult<BlacklistRespVO> page(BlacklistPageReqVO pageReqVO) {
        LambdaQueryWrapper<BlacklistDO> wrapper = new LambdaQueryWrapper<>();
        if (pageReqVO.getTarget() != null) wrapper.eq(BlacklistDO::getTarget, pageReqVO.getTarget());
        if (pageReqVO.getIsIp() != null) wrapper.eq(BlacklistDO::getIsIp, pageReqVO.getIsIp());
        if (pageReqVO.getIsActive() != null) wrapper.eq(BlacklistDO::getIsActive, pageReqVO.getIsActive());
        Page<BlacklistDO> page = new Page<>(pageReqVO.getPageNo(), pageReqVO.getPageSize());
        Page<BlacklistDO> result = mapper.selectPage(page, wrapper);
        List<BlacklistRespVO> list = convert.convertList(result.getRecords());
        return new PageResult<>(list, result.getTotal());
    }
} 