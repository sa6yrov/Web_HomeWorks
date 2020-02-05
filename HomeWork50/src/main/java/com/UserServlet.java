package com;

import DbConnection.DbConn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@WebServlet("/boo")
public class UserServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(req.getParameter("login"), req.getParameter("password"), req.getParameter("email"),
                            req.getParameter("gender"));
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<html> <head> <title>UserInfo</title></head><body><p align = center>");
        printWriter.print(user.getLogin() + "<br><br>");
        printWriter.print(user.getPassword() + "<br><br>");
        printWriter.print(user.getEmail() + "<br><br>");
        printWriter.print(user.getGender()+ "<br><br>");
        printWriter.print("</p></body></html>");
        System.out.println(user);
    }
}
