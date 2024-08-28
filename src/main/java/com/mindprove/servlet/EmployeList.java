package com.mindprove.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/list")
public class EmployeList extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        try {

            Connection con = null;
            PreparedStatement ps = null;

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("load the driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emprecord", "root", "root");

            System.out.println("connection created successfully");

            ps = con.prepareStatement("SELECT * FROM emptabel");

            ResultSet rs = ps.executeQuery();

            out.println("<html><body>");
            out.println("<h1>Employee List</h1>");
            out.println("<table border='1' cellpadding='10'>");
            out.println("<tr><th>Name</th><th>Email</th><th>Phone</th><th>Salary</th><th>Designation</th><th>City</th></tr>");

            while (rs.next()) {

                String name = rs.getString(1);
                String email = rs.getString(2);
                String phone = rs.getString(3);
                String salary = rs.getString(4);
                String designation = rs.getString(5);
                String city = rs.getString(6);

                out.println("<tr>");
                out.println("<td>" + name + "</td>");
                out.println("<td>" + email + "</td>");
                out.println("<td>" + phone + "</td>");
                out.println("<td>" + salary + "</td>");
                out.println("<td>" + designation + "</td>");
                out.println("<td>" + city + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}

