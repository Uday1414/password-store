package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.dto.DetailsDto;
import com.ty.dto.UserDto;
import com.ty.service.DetailsService;

@WebServlet(value = "/add")
public class AddUser extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String webLink = req.getParameter("weblink");
		String description = req.getParameter("description");
		PrintWriter printWriter = resp.getWriter();
		HttpSession httpSession = req.getSession();
		UserDto user = (UserDto) httpSession.getAttribute("myusername");
		if(user!=null) {

		DetailsDto detailsDto = new DetailsDto();
		detailsDto.setName(name);
		detailsDto.setPassword(password);
		detailsDto.setWebLink(webLink);
		detailsDto.setDescription(description);

		DetailsService detailsService = new DetailsService();
		DetailsDto saved = detailsService.saveDetails(detailsDto, user.getId());
		
		if (saved != null) {
			printWriter.write("<html><body>");
			printWriter.write("<h1>hello Details saved </h1>");
			printWriter.write("</body></html>");
			resp.sendRedirect("home.html");

		} else {
			printWriter.write("<html><body>");
			printWriter.write("<h1> Details Not Saved</hl>");
			printWriter.write("</body></html>");
		}
		}else {
			printWriter.write("<html><body>");
			printWriter.write("<h1> Details Not Saved</hl>");
			printWriter.write("</body></html>");
		}
	}
}
