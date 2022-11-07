package com.cxy.crm.service.impl;

import com.cxy.crm.mapper.StudentMapper;
import com.cxy.crm.pojo.Student;
import com.cxy.crm.service.StudentService;
import com.cxy.crm.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> selectAll() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectAll();
        sqlSession.close();
        return students;
    }
}
