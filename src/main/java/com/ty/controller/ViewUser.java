package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.dto.DetailsDto;
import com.ty.dto.UserDto;
import com.ty.service.DetailsService;
@WebServlet(value = "/view")
public class ViewUser extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		PrintWriter printWriter = resp.getWriter();
		UserDto userDto = (UserDto) (httpSession.getAttribute("myusername"));
		DetailsService detailsService = new DetailsService();
		List<DetailsDto> detailsDtos = detailsService.getByUserId(userDto.getId());
		if (detailsDtos.size() > 0) {
			printWriter.write("<html><body><table style=boder 4px >");
			printWriter.write("<tr><th>Id</th><th>Name</th><th>Password</th><th>website</th><th>description</th></tr>");
			for (DetailsDto detailsDto : detailsDtos) {
				printWriter.write("<tr><td>" + detailsDto.getId() +"</td>");
				printWriter.write("<td>" + detailsDto.getName()+"</td>");
				printWriter.write("<td>" + detailsDto.getPassword() + "</td>");
				printWriter.write("<td>" + detailsDto.getWebLink() + "</td>");
				printWriter.write("<td>" + detailsDto.getDescription() + "</td></tr>");
			}
			printWriter.write("</table></body></html>");
		} else {
			printWriter.write("<html><body>");
			printWriter.write("<h1>No Details added yet</hl>");
			printWriter.write("</body></html>");
		}
	}
}
