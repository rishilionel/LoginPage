package userentry;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class signin extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("name");
		String password = request.getParameter("pswd");
		boolean condition=true;
		Daoclass3 obj1=null;
		try {
			obj1 = new Daoclass3(uname);
			condition=obj1.checkavail();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			condition=false;
		}
		if(condition==false)
		{
		try {
			Daoclass2 obj2 = new Daoclass2(uname,password);
			response.sendRedirect("index.html");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("gone wrong");
			e.printStackTrace();
		}
		}
		else
		{
			System.out.println("username taken");
			response.sendRedirect("sign.html");
		}
	}
}
