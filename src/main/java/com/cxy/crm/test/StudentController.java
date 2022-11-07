package com.cxy.crm.test;

import com.cxy.crm.pojo.Student;
import com.cxy.crm.service.StudentService;
import com.cxy.crm.service.impl.StudentServiceImpl;

import java.util.List;

public class StudentController {
    public static void main(String[] args) {
        StudentService ss=new StudentServiceImpl();
        List<Student> students = ss.selectAll();
        students.forEach(student -> System.out.println(student));
    }
}
