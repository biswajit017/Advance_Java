package task_Day4;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
//@WebServlet("/loginpage")
public class Task extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String name = req.getParameter("username");
		String password = req.getParameter("pass");
		
		ServletConfig sc = getServletConfig();
		String validname = sc.getInitParameter("name");
		String validpass = sc.getInitParameter("password");
		
		if(name.equals(validname) && password.equals(validpass))
		{
			req.setAttribute("name", name);
			req.getRequestDispatcher("Display.jsp").forward(req, res);

		}
		
		else
		{
			pw.println("<h2 style='color:Red;'>Invalid Username And Password..</h2>");
			req.getRequestDispatcher("Index.html").include(req, res);
		}
		
		
		
		
	}

}
