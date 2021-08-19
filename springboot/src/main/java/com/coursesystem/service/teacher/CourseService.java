package com.coursesystem.service.teacher;

import com.coursesystem.model.vo.response.ResultVO;
import com.coursesystem.util.LessonTimeConverter;
import com.coursesystem.manager.teacher.CourseManager;
import com.coursesystem.model.vo.response.table.TeacherCourseItemVO;
import com.coursesystem.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacher_courseService")
public class CourseService extends BaseService {
    private final CourseManager manager;
    private final LessonTimeConverter lessonTimeConverter;

    public CourseService(CourseManager manager, LessonTimeConverter lessonTimeConverter) {
        this.manager = manager;
        this.lessonTimeConverter = lessonTimeConverter;
    }

    public ResultVO list() {
        Integer teacherId = getUserId();

        List<TeacherCourseItemVO> list = manager.listTeacherCourse(teacherId);
        for (TeacherCourseItemVO vo : list) {
            vo.setTime(lessonTimeConverter.covertTimePart(vo.getTime()));
        }

        return result(list);
    }
}
