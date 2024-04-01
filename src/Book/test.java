/*
 * 太原科技大学。
 * Copyright 2021, YCHS Information&Science Technology Co.,Ltd,
 * All rights reserved.
 */
package Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author liuchao
 * @version 1.0
 * @date 2024/3/5
 */

@WebServlet(value = "/login")
public class test extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1处理乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //2接收数据
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        System.out.println(username+" "+pwd);
        //4直接判断
        if(username.equals("admin")&&pwd.equals("888")){
            //重定向到BooKList
            response.sendRedirect(" BookServlet");
        }else{
            //重定向
            response.sendRedirect("login.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
