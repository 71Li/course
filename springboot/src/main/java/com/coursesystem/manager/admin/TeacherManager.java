package com.coursesystem.manager.admin;

import com.coursesystem.dao.CourseDAO;
import com.coursesystem.dao.DepartmentDAO;
import com.coursesystem.dao.TeacherDAO;
import com.coursesystem.model.vo.response.IdNameVO;
import com.coursesystem.manager.BaseManager;
import com.coursesystem.model.entity.DepartmentEntity;
import com.coursesystem.model.entity.TeacherEntity;
import com.coursesystem.model.vo.response.table.TeacherItemVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherManager extends BaseManager {
    private final DepartmentDAO departmentDAO;
    private final TeacherDAO teacherDAO;
    private final CourseDAO courseDAO;

    public TeacherManager(DepartmentDAO departmentDAO, TeacherDAO teacherDAO, CourseDAO courseDAO) {
        this.departmentDAO = departmentDAO;
        this.teacherDAO = teacherDAO;
        this.courseDAO = courseDAO;
    }

    public Integer getPageCount(String departmentName, String name) {
        int count = teacherDAO.count(departmentName, name);
        return calcPageCount(count, TeacherDAO.PAGE_SIZE);
    }

    public List<TeacherItemVO> getPage(Integer index, String departmentName, String name) {
        return teacherDAO.getPage(index, departmentName, name);
    }

    public TeacherEntity get(Integer id) {
        return teacherDAO.get(id);
    }

    public int create(TeacherEntity entity) {
        return teacherDAO.insert(entity);
    }

    public int update(TeacherEntity entity) {
        return teacherDAO.update(entity);
    }

    public int delete(Integer id) {
        return teacherDAO.delete(id);
    }

    public boolean hasCourse(Integer teacherId) {
        return courseDAO.countByTeacherId(teacherId) > 0;
    }

    public DepartmentEntity getDepartmentById(Integer id) {
        return departmentDAO.get(id);
    }

    public List<IdNameVO> listName() {
        List<IdNameVO> voList = new ArrayList<>();
        List<TeacherEntity> entityList = teacherDAO.listName();
        for (TeacherEntity entity : entityList) {
            voList.add(new IdNameVO(entity.getId(), entity.getName()));
        }

        return voList;
    }
}
