package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbcp.BasicDataSource;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ServletContext application = request.getServletContext();
		BasicDataSource dataSource = (BasicDataSource) application.getAttribute("dataSource");

		try {
			Connection connection = dataSource.getConnection();
			String sql = "select count(*) from trpgmember where username=? and password=?";
			PreparedStatement st = connection.prepareStatement(sql);

			st.setString(1, username);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();

			rs.next();
			if (rs.getInt(1) == 0) {
				request.setAttribute("msg", "驗證不通過");
			} else {
				HttpSession session = request.getSession();
				Cookie cookie = new Cookie("trpg", session.getId());
				response.addCookie(cookie);

				request.setAttribute("msg", "驗證通過");
			}

		} catch (SQLException e) {
			request.setAttribute("msg", e.getMessage());
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);

	}

}
