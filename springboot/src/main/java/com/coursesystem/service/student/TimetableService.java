package com.coursesystem.service.student;

import com.coursesystem.model.vo.response.ResultVO;
import com.coursesystem.manager.student.TimetableManager;
import com.coursesystem.service.BaseService;
import org.springframework.stereotype.Service;

@Service("student_timetableService")
public class TimetableService extends BaseService {
    private final TimetableManager manager;

    public TimetableService(TimetableManager manager) {
        this.manager = manager;
    }

    public ResultVO get() {
        Integer studentId = getUserId();
        return result(manager.listStudentTimetable(studentId));
    }
}
