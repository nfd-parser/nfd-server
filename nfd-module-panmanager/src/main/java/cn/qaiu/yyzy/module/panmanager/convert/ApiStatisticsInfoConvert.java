package cn.qaiu.yyzy.module.panmanager.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApiStatisticsInfoConvert {
    ApiStatisticsInfoConvert INSTANCE = Mappers.getMapper(ApiStatisticsInfoConvert.class);
} 