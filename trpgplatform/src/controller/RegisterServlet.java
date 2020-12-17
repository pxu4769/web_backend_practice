package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp.BasicDataSource;

import bean.Member;
import dao.MemberDao;

public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		ServletContext application=request.getServletContext();
		BasicDataSource dataSource=(BasicDataSource)application.getAttribute("dataSource");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Member member = new Member();
		member.setUsername(username);
		member.setPassword(password);
		
		try {
			MemberDao dao = new MemberDao();
			dao.setDataSource(dataSource);
			dao.insert(member);
			
			request.setAttribute("username", username);
			request.getRequestDispatcher("showresult.jsp").forward(request,response);
			
		} catch (SQLException e) {
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("showfailure.jsp").forward(request,response);
		}
		
	}
	
}
