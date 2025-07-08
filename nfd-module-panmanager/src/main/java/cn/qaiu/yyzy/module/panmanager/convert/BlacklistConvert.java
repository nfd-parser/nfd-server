package cn.qaiu.yyzy.module.panmanager.convert;

import cn.qaiu.yyzy.module.panmanager.dal.dataobject.BlacklistDO;
import cn.qaiu.yyzy.module.panmanager.controller.admin.blacklist.vo.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BlacklistConvert {
    BlacklistConvert INSTANCE = Mappers.getMapper(BlacklistConvert.class);
    BlacklistDO convert(BlacklistSaveReqVO bean);
    BlacklistRespVO convert(BlacklistDO bean);
    List<BlacklistRespVO> convertList(List<BlacklistDO> list);
} 