package com.yf.data;

import com.yf.entity.Student;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*********************************************************
 **
 ** <br><br>
 ** @ClassName: DB
 ** @author: yangfeng
 ** @date: 2024/7/9 11:53
 ** @version: 1.0.0
 *********************************************************/
public class DB {
    private static Map<Integer, Student> dbMap = new LinkedHashMap<>();

    static {
        dbMap.put(1, new Student(1, "张三", 0));
        dbMap.put(2, new Student(2, "李四", 0));
        dbMap.put(3, new Student(3, "王五", 0));
        dbMap.put(4, new Student(4, "赵六", 0));
        dbMap.put(5, new Student(5, "张七", 0));
    }

    public static List<Student> getAll() {
        List<Student> list = new ArrayList<>();
        dbMap.forEach((key, value) -> {
            // 处理键和值
            list.add(value);
        });
        return list;
    }

    public static boolean updateById(Student entity) {
        dbMap.put(entity.getId(),entity);
        return true;
    }

    public static Student getById(Integer id) {
        return dbMap.get(id);
    }
}


