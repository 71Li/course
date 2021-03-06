package com.coursesystem.controller.teacher;

import com.coursesystem.model.vo.response.ResultVO;
import com.coursesystem.config.themis.annotation.Teacher;
import com.coursesystem.controller.BaseController;
import com.coursesystem.service.teacher.TimetableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Teacher
@RequestMapping("/teacher/timetable")
@RestController
public class TimetableController extends BaseController {
    private final TimetableService service;

    public TimetableController(TimetableService service) {
        this.service = service;
    }

    @RequestMapping
    public ResultVO get() {
        return service.get();
    }
}
