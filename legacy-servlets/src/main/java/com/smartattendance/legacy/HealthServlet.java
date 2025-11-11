package com.smartattendance.legacy;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.sql.*;

public class HealthServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain");
        try(PrintWriter out = res.getWriter()){
            // simple JDBC ping
            try(Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance_db","root","password")){
                out.println("OK - DB Connected");
            } catch(Exception ex){
                out.println("WARN - DB not connected: "+ex.getMessage());
            }
        }
    }
}
