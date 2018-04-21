package com.lunwen.ztt.controller;

import com.lunwen.ztt.model.StudentSelectLesson;
import com.lunwen.ztt.service.StudentSelectLessonService;
import com.lunwen.ztt.view.StudentLesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 * author: daydayofzheng
 * Date: 18-4-21
 * Time: 下午3:04
 */

@RestController
@RequestMapping(value = "/ssl")
public class StudentSelectLessonController {

    /** 学生选课数据访问对象*/
    @Autowired
    private StudentSelectLessonService studentSelectLessonService;


    /**
     * 获得学生选修的所有课程
     * @param sno 学号
     * @return map
     */
    @RequestMapping(value = "/getAllSsl", method = RequestMethod.GET)
    public Map<String, Object> getAllSsl(String sno) {
        List<StudentLesson> list = studentSelectLessonService.getAllSsl(sno);
        Map<String, Object> map = new HashMap<>();
        map.put("studentLesson", list);
        return map;
    }

    /**
     * 保存ssl
     * @param studentSelectLesson ssl
     * @return boolean
     */
    @RequestMapping(value = "/saveSsl", method = RequestMethod.POST)
    public boolean saveSsl(@RequestBody StudentSelectLesson studentSelectLesson) {
        return studentSelectLessonService.saveSsl(studentSelectLesson);
    }
}
