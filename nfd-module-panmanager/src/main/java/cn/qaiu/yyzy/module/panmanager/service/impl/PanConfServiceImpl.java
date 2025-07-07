package cn.qaiu.yyzy.module.panmanager.service.impl;

import cn.qaiu.yyzy.framework.common.exception.util.ServiceExceptionUtil;
import cn.qaiu.yyzy.module.panmanager.controller.admin.panconf.vo.PanConfReqVO;
import cn.qaiu.yyzy.module.panmanager.controller.admin.panconf.vo.PanConfRespVO;
import cn.qaiu.yyzy.module.panmanager.controller.admin.panconf.vo.PanConfSaveReqVO;
import cn.qaiu.yyzy.module.panmanager.dal.dataobject.PanConfDO;
import cn.qaiu.yyzy.module.panmanager.dal.mysql.PanConfMapper;
import cn.qaiu.yyzy.module.panmanager.service.PanConfService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

import static cn.qaiu.yyzy.module.panmanager.enums.ErrorCodeConstants.PAN_CONF_NOT_EXISTS;

/**
 * 网盘配置 Service 实现类
 */
@Service
@Validated
public class PanConfServiceImpl extends ServiceImpl<PanConfMapper, PanConfDO> implements PanConfService {

    @Resource
    private PanConfMapper panConfMapper;

    @Override
    public Long createPanConf(PanConfSaveReqVO createReqVO) {
        // 插入
        PanConfDO panConf = new PanConfDO();
        BeanUtils.copyProperties(createReqVO, panConf);
        panConfMapper.insert(panConf);
        // 返回
        return panConf.getId();
    }

    @Override
    public void updatePanConf(PanConfSaveReqVO updateReqVO) {
        // 校验存在
        validatePanConfExists(updateReqVO.getId());
        // 更新
        PanConfDO updateObj = new PanConfDO();
        BeanUtils.copyProperties(updateReqVO, updateObj);
        panConfMapper.updateById(updateObj);
    }

    @Override
    public void deletePanConf(Long id) {
        // 校验存在
        validatePanConfExists(id);
        // 删除
        panConfMapper.deleteById(id);
    }

    private void validatePanConfExists(Long id) {
        if (panConfMapper.selectById(id) == null) {
            throw ServiceExceptionUtil.exception(PAN_CONF_NOT_EXISTS);
        }
    }

    @Override
    public PanConfRespVO getPanConf(Long id) {
        PanConfDO panConf = panConfMapper.selectById(id);
        if (panConf == null) {
            return null;
        }
        PanConfRespVO respVO = new PanConfRespVO();
        BeanUtils.copyProperties(panConf, respVO);
        return respVO;
    }

    @Override
    public IPage<PanConfRespVO> getPanConfPage(PanConfReqVO pageReqVO) {
        Page<PanConfDO> pageParam = new Page<>(pageReqVO.getPageNo(), pageReqVO.getPageSize());
        
        // 构建查询条件
        LambdaQueryWrapper<PanConfDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(pageReqVO.getPanUser() != null, PanConfDO::getPanUser, pageReqVO.getPanUser())
                   .like(pageReqVO.getPanType() != null, PanConfDO::getPanType, pageReqVO.getPanType())
                   .eq(pageReqVO.getEnable() != null, PanConfDO::getEnable, pageReqVO.getEnable())
                   .orderByDesc(PanConfDO::getId);

        Page<PanConfDO> panConfDOPage = panConfMapper.selectPage(pageParam, queryWrapper);

        return panConfDOPage.convert(panConfDO -> {
            PanConfRespVO respVO = new PanConfRespVO();
            BeanUtils.copyProperties(panConfDO, respVO);
            return respVO;
        });
    }

}
