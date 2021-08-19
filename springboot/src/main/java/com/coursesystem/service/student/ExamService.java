package com.coursesystem.service.student;

import com.coursesystem.model.vo.response.ResultVO;
import com.coursesystem.manager.student.ExamManager;
import com.coursesystem.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ExamService extends BaseService {
    private final ExamManager manager;

    public ExamService(ExamManager manager) {
        this.manager = manager;
    }

    public ResultVO list() {
        return result(manager.listStudentExam(getUserId()));
    }
}
