package com.mindprove.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.mindprove.Employedto.EmployeDTO;
import com.mindprove.service.EmployeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/empregester")
public class EmployeeRegester extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	  PrintWriter out =resp.getWriter();
		resp.setContentType("text/html");
		

		out.println("<html>");
		
		out.println("<head>");
		
		out.println("</head>");
		
		out.println("<form action= '/EmployeeManagment/empregester' method= 'post'>");
		
		out.println("<label for ='name'>Name :</label>");
		out.println("<input type='text' name=name>");
		out.println("<br>");
		out.println("<br>");
		
		out.println("<label for ='name'> Email :</label>");
		out.println("<input type ='text' name=email>");
		out.println("<br>");
		out.println("<br>");
		
		out.println("<label for='name'> Phone :</label>");
		out.println("<input type ='text' name=phone>");
		out.println("<br>");
		out.println("<br>");
		
		out.println("<label for= 'name'> Salary :</label>");
		out.println("<input type= 'text' name=salary>");
		out.println("<br>");
		out.println("<br>");
		
		out.println("<label for ='name'> Designation :</label>");
		out.println("<input type ='text' name=designation>");
		out.println("<br>");
		out.println("<br>");
		
		out.println("<label for ='name'> City :</label>");
		out.println("<input type ='text' name=city>");
		out.println("<br>");
		out.println("<br>");
		
		out.println("<input type='submit' value= 'regester'>");
		
		out.println("</form>");
		out.println("</html>"); 
	  
}
  
  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	  PrintWriter out =resp.getWriter();
	  resp.setContentType("text/html");
	  
	  
	  String name= req.getParameter("name");
	  String email= req.getParameter("email");
	  String phone= req.getParameter("phone");
	  String salary= req.getParameter("salary");
	  String designation=  req.getParameter("designation");
	   String city = req.getParameter("city");
	  
	   
	   
	   
	   EmployeDTO data =new EmployeDTO();
	   
	   data.setName(name);
	   data.setEmail(email);
	   data.setPhone(phone);
	   data.setSalary(salary);
	   data.setDesignation(designation);
	   data.setCity(city);
	   
	   EmployeService service =new EmployeService();
	   
	   boolean isregester = service.save(data);
	   
	   if(isregester) {
		   
		   //out.println("<h1> Regester successfully");
	   
	     resp.sendRedirect("/list");
	   }
	   
	   else {
		   
		   out.println("<h1> Regester not successfully");
	   }
	   
	  
	  
	}
	
}
