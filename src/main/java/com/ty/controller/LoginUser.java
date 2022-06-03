package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.dto.UserDto;
import com.ty.service.UserService;
@WebServlet(value = "/login")
public class LoginUser extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp); 
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password  = req.getParameter("password");
		PrintWriter printWriter = resp.getWriter();
		UserService service = new UserService() ;
		UserDto saved = service.validateUser(email,password) ;
		if(saved!=null) {
			
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("myusername", saved);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("home.html");
			dispatcher.forward(req, resp);
		}else {
			printWriter.write("<html><body><h1> Email or Password Wrong </h1></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
			dispatcher.include(req, resp);
		}
	}
}
