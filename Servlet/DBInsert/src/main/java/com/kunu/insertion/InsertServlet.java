package com.kunu.insertion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public InsertServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empID = Integer.parseInt(request.getParameter("empID"));
        String name = request.getParameter("name");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        String message = "Insertion Failed";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "kunu9090");
                 PreparedStatement pst = con.prepareStatement("INSERT INTO Empployee71 VALUES (?,?,?,?,?,?)")) {

                pst.setInt(1, empID);
                pst.setString(2, name);
                pst.setDouble(3, salary);
                pst.setString(4, address);
                pst.setString(5, email);
                pst.setString(6, phone);

                int k = pst.executeUpdate();
                if (k > 0) {
                    message = "Successfully Inserted.";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            message = "Insertion Failed: " + e.getMessage();
        }

        response.sendRedirect("Successfull.jsp?message=" + message);
    }
}
