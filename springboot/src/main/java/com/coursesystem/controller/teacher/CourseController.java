package com.coursesystem.controller.teacher;

import com.coursesystem.model.vo.response.ResultVO;
import com.coursesystem.config.themis.annotation.Teacher;
import com.coursesystem.controller.BaseController;
import com.coursesystem.service.teacher.CourseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Teacher
@RequestMapping("/teacher/course")
@RestController("teacher_courseController")
public class CourseController extends BaseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @RequestMapping("/list")
    public ResultVO list() {
        return service.list();
    }
}
