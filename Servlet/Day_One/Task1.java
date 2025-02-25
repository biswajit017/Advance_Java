package day_One;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/client")
public class Task1 implements Servlet
{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		
		String id = req.getParameter("fid");
		String first = req.getParameter("fname");
		String last = req.getParameter("lname");
		String email = req.getParameter("umail");
		String phone = req.getParameter("phno");
		
		PrintWriter writer = res.getWriter();
		res.setContentType("text/html");
		
		writer.println("UserID : " + id + "<br>" );
		writer.println("First Name : " + first + "<br>" );
		writer.println("Last Name : " + last + "<br>" );
		writer.println("Email : " + email + "<br>" );
		writer.println("Phone Number : " + phone + "<br>" );

	}
	

}
