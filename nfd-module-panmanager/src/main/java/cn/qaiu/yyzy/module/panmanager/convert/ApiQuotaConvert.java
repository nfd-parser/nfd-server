package cn.qaiu.yyzy.module.panmanager.convert;

import cn.qaiu.yyzy.module.panmanager.dal.dataobject.ApiQuotaDO;
import cn.qaiu.yyzy.module.panmanager.controller.admin.apiquota.vo.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ApiQuotaConvert {
    ApiQuotaConvert INSTANCE = Mappers.getMapper(ApiQuotaConvert.class);
    ApiQuotaDO convert(ApiQuotaSaveReqVO bean);
    ApiQuotaRespVO convert(ApiQuotaDO bean);
    List<ApiQuotaRespVO> convertList(List<ApiQuotaDO> list);
} 