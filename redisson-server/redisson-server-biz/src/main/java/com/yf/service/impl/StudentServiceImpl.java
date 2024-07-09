package com.yf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yf.entity.Student;
import com.yf.service.StudentService;
import com.yf.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
* @author yangfeng
* @description 针对表【student】的数据库操作Service实现
* @createDate 2024-07-09 15:46:30
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

}




