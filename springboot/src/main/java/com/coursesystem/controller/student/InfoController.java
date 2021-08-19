package com.coursesystem.controller.student;

import com.coursesystem.model.vo.request.StudentInfoFormVO;
import com.coursesystem.model.vo.response.ResultVO;
import com.coursesystem.config.themis.annotation.Student;
import com.coursesystem.controller.BaseController;
import com.coursesystem.service.student.InfoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Student
@RequestMapping("/student/info")
@RestController
public class InfoController extends BaseController {
    private final InfoService service;

    public InfoController(InfoService service) {
        this.service = service;
    }

    @GetMapping
    public ResultVO get() {
        return service.get();
    }

    @PutMapping
    public ResultVO update(@RequestBody @Validated StudentInfoFormVO formVO) {
        return service.update(formVO);
    }
}
