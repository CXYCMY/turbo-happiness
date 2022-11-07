package com.cxy.crm.servlet;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpsServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/123")
public class StudentMyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
//        out.print("不给糖就捣乱");
        //{"name":"zhangsan","age":18}
        out.print("{\"name\":\"zhangsan\",\"age\":18}");
        System.out.println("Servlet实现了");
    }
}
