package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.UserDto;
import com.ty.service.UserService;
@WebServlet(value = "/register")
public class RegisterUser extends HttpServlet {
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name") ;
		String email = req.getParameter("email") ;
		String password = req.getParameter("password") ;
		String gender = req.getParameter("gender") ;
		long phone = Long.parseLong(req.getParameter("phone") );
		
		UserDto dto = new UserDto() ;
		
		dto.setName(name);
		dto.setEmail(email);
		dto.setPassword(password);
		dto.setGender(gender);
		dto.setPhone(phone);
		
		UserService service = new UserService() ;
		UserDto saved = service.saveUser(dto) ;
		PrintWriter printWriter = resp.getWriter() ;
		
		if(saved != null) {
				
			printWriter.write("<html><body>");
			printWriter.write("<h1>Registered succesfully</h1>");
			printWriter.write("</body></html>");
			resp.sendRedirect("login.html");
			
		}else {
			printWriter.write("<html><body>");
			printWriter.write("<h1>Registration failed</hl>");
			printWriter.write("</body></html>");
		}
		
	}
}
