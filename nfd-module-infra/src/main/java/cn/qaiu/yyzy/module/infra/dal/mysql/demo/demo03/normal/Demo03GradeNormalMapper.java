package cn.qaiu.yyzy.module.infra.dal.mysql.demo.demo03.normal;

import cn.qaiu.yyzy.framework.mybatis.core.mapper.BaseMapperX;
import cn.qaiu.yyzy.module.infra.dal.dataobject.demo.demo03.Demo03GradeDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 学生班级 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface Demo03GradeNormalMapper extends BaseMapperX<Demo03GradeDO> {

    default Demo03GradeDO selectByStudentId(Long studentId) {
        return selectOne(Demo03GradeDO::getStudentId, studentId);
    }

    default int deleteByStudentId(Long studentId) {
        return delete(Demo03GradeDO::getStudentId, studentId);
    }

    default int deleteByStudentIds(List<Long> studentIds) {
        return deleteBatch(Demo03GradeDO::getStudentId, studentIds);
    }

}
