package com.coursesystem.manager.student;

import com.coursesystem.dao.CourseDAO;
import com.coursesystem.dao.StudentCourseDAO;
import com.coursesystem.dao.StudentDAO;
import com.coursesystem.model.bo.StudentCourseSelectItemBO;
import com.coursesystem.manager.BaseManager;
import com.coursesystem.model.entity.CourseEntity;
import com.coursesystem.model.entity.StudentCourseEntity;
import com.coursesystem.model.entity.StudentEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CourseSelectManager extends BaseManager {
    private final CourseDAO courseDAO;
    private final StudentDAO studentDAO;
    private final StudentCourseDAO studentCourseDAO;

    public CourseSelectManager(CourseDAO courseDAO, StudentDAO studentDAO, StudentCourseDAO studentCourseDAO) {
        this.courseDAO = courseDAO;
        this.studentDAO = studentDAO;
        this.studentCourseDAO = studentCourseDAO;
    }

    public Integer getPageCount(Integer studentId, String courseName, String teacherName) {
        Integer departmentId = studentDAO.getDepartmentIdById(studentId);
        Integer grade = studentDAO.getGradeById(studentId);
        return calcPageCount(courseDAO.countStudentCanSelect(departmentId, studentId, grade, courseName, teacherName), StudentCourseDAO.PAGE_SIZE);
    }

    public List<StudentCourseSelectItemBO> getPage(Integer index, Integer studentId, String courseName, String teacherName) {
        Integer departmentId = studentDAO.getDepartmentIdById(studentId);
        Integer grade = studentDAO.getGradeById(studentId);
        return courseDAO.getStudentCanSelectPage(index, departmentId, studentId, grade, courseName, teacherName);
    }

    public CourseEntity getCourseById(Integer courseId) {
        return courseDAO.get(courseId);
    }

    public StudentEntity getStudentById(Integer studentId) {
        return studentDAO.get(studentId);
    }

    public boolean inSameDepartment(Integer courseId, Integer studentId) {
        return courseDAO.getDepartmentIdById(courseId)
                .equals(studentDAO.getDepartmentIdById(studentId));
    }

    public StudentCourseEntity getStudentCourseByCourseIdAndStudentId(Integer courseId, Integer studentId) {
        return studentCourseDAO.getByCourseIdAndStudentId(courseId, studentId);
    }

    public Integer getStudentGradeById(Integer studentId) {
        return studentDAO.getGradeById(studentId);
    }

    @Transactional
    public int create(StudentCourseEntity entity) {
        courseDAO.increaseSelectedCount(entity.getCourseId());
        return studentCourseDAO.insert(entity);
    }

    public int countStudentCourseSelectedByTimePart(Integer studentId, String timePart) {
        return studentCourseDAO.countStudentCourseSelectedByTimePart(studentId, timePart);
    }
}
