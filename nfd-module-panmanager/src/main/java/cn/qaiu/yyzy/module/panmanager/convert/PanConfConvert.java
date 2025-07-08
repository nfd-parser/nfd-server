package cn.qaiu.yyzy.module.panmanager.convert;

import cn.qaiu.yyzy.module.panmanager.controller.admin.panconf.vo.PanConfRespVO;
import cn.qaiu.yyzy.module.panmanager.controller.admin.panconf.vo.PanConfSaveReqVO;
import cn.qaiu.yyzy.module.panmanager.dal.dataobject.PanConfDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 网盘配置 Convert
 */
@Mapper
public interface PanConfConvert {

    PanConfConvert INSTANCE = Mappers.getMapper(PanConfConvert.class);

    PanConfDO convert(PanConfSaveReqVO bean);

    PanConfRespVO convert(PanConfDO bean);

    List<PanConfRespVO> convertList(List<PanConfDO> list);

} 