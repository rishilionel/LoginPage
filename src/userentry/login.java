package userentry;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(description = "used for login into account", urlPatterns = { "/welcome" })
public class login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("pswd");
		boolean value=false;
		Daoclass1 check = null;
		try {
			check = new Daoclass1(name, password);
			value=check.end();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(value)
		{
			request.setAttribute("name", name);
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("wrong");
			response.sendRedirect("index.html");
		}
	}
}
