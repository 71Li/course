package com.coursesystem.manager.student;

import com.coursesystem.dao.StudentDAO;
import com.coursesystem.model.vo.response.StudentInfoVO;
import com.coursesystem.manager.BaseManager;
import com.coursesystem.model.entity.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class InfoManager extends BaseManager {
    private final StudentDAO studentDAO;

    public InfoManager(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public StudentInfoVO getStudentInfoByStudentId(Integer studentId) {
        return studentDAO.getStudentInfoById(studentId);
    }

    public StudentEntity getStudentById(Integer studentId) {
        return studentDAO.get(studentId);
    }

    public int updateStudent(StudentEntity entity) {
        return studentDAO.update(entity);
    }
}
