package com.coursesystem.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.coursesystem.model.vo.response.StudentInfoVO;
import com.coursesystem.model.entity.StudentEntity;
import com.coursesystem.model.vo.response.table.StudentItemVO;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper extends BaseMapper<StudentEntity> {
    Integer getDepartmentIdById(Integer studentId);

    Integer getGradeById(Integer studentId);

    Integer count(String majorName, String className, String name);

    IPage<StudentItemVO> getPage(IPage<StudentItemVO> page, String majorName, String className, String name);

    StudentInfoVO getStudentInfoById(Integer studentId);
}
