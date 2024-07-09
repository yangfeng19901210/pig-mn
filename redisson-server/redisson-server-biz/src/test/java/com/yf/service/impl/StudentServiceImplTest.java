package com.yf.service.impl;

import com.yf.entity.Student;
import com.yf.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentServiceImplTest {
    @Resource
    private StudentService studentService;
    @Test
    public void saveBatch(){
        List<Student> list = new ArrayList<>();
        Student s1 = new Student();
        s1.setName("张三");
        Student s2 = new Student();
        s2.setName("李四");
        Student s3 = new Student();
        s3.setName("王五");
        Student s4 = new Student();
        s4.setName("赵六");
        Student s5 = new Student();
        s5.setName("张七");
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        studentService.saveBatch(list);
    }

}