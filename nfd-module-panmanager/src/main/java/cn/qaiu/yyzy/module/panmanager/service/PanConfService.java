package cn.qaiu.yyzy.module.panmanager.service;

import cn.qaiu.yyzy.module.panmanager.controller.admin.panconf.vo.PanConfReqVO;
import cn.qaiu.yyzy.module.panmanager.controller.admin.panconf.vo.PanConfRespVO;
import cn.qaiu.yyzy.module.panmanager.controller.admin.panconf.vo.PanConfSaveReqVO;
import cn.qaiu.yyzy.module.panmanager.dal.dataobject.PanConfDO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.validation.Valid;

/**
 * 网盘配置 Service 接口
 */
public interface PanConfService extends IService<PanConfDO> {

    /**
     * 创建网盘配置
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPanConf(@Valid PanConfSaveReqVO createReqVO);

    /**
     * 更新网盘配置
     *
     * @param updateReqVO 更新信息
     */
    void updatePanConf(@Valid PanConfSaveReqVO updateReqVO);

    /**
     * 删除网盘配置
     *
     * @param id 编号
     */
    void deletePanConf(Long id);

    /**
     * 获得网盘配置
     *
     * @param id 编号
     * @return 网盘配置
     */
    PanConfRespVO getPanConf(Long id);

    /**
     * 获得网盘配置分页
     *
     * @param pageReqVO 分页查询
     * @return 网盘配置分页
     */
    IPage<PanConfRespVO> getPanConfPage(PanConfReqVO pageReqVO);

}
