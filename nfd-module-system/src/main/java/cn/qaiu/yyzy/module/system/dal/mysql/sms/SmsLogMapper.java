package cn.qaiu.yyzy.module.system.dal.mysql.sms;

import cn.qaiu.yyzy.framework.common.pojo.PageResult;
import cn.qaiu.yyzy.framework.mybatis.core.mapper.BaseMapperX;
import cn.qaiu.yyzy.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.qaiu.yyzy.module.system.controller.admin.sms.vo.log.SmsLogPageReqVO;
import cn.qaiu.yyzy.module.system.dal.dataobject.sms.SmsLogDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SmsLogMapper extends BaseMapperX<SmsLogDO> {

    default PageResult<SmsLogDO> selectPage(SmsLogPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SmsLogDO>()
                .eqIfPresent(SmsLogDO::getChannelId, reqVO.getChannelId())
                .eqIfPresent(SmsLogDO::getTemplateId, reqVO.getTemplateId())
                .likeIfPresent(SmsLogDO::getMobile, reqVO.getMobile())
                .eqIfPresent(SmsLogDO::getSendStatus, reqVO.getSendStatus())
                .betweenIfPresent(SmsLogDO::getSendTime, reqVO.getSendTime())
                .eqIfPresent(SmsLogDO::getReceiveStatus, reqVO.getReceiveStatus())
                .betweenIfPresent(SmsLogDO::getReceiveTime, reqVO.getReceiveTime())
                .orderByDesc(SmsLogDO::getId));
    }

}
