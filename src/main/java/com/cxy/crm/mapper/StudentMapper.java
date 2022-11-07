package com.cxy.crm.mapper;

import com.cxy.crm.pojo.Student;

import java.util.List;

public interface StudentMapper {
    /**
     * 查询student的所有数据
     * @return
     */
     List<Student> selectAll();
}
