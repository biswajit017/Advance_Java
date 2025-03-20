package com.kunu.dbretrive;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Servlet1() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html"); // Set response type to HTML

        int id = Integer.parseInt(request.getParameter("id"));

        // Start HTML table
        out.println("<table border='1' width='1050px' style='margin: auto; text-align: center; border-collapse: collapse;'>");
        out.println("<tr><th> ID </th><th> Name </th><th> Salary </th><th> Address </th><th> MailID </th><th> PhNo </th></tr>");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "kunu9090");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Empployee71 WHERE empID=" + id);

            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt(1) + "</td>" +
                            "<td>" + rs.getString(2) + "</td>" +
                            "<td>" + rs.getDouble(3) + "</td>" +
                            "<td>" + rs.getString(4) + "</td>" +
                            "<td>" + rs.getString(5) + "</td>" +
                            "<td>" + rs.getString(6) + "</td></tr>");
            }

            out.print("</table>");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
