package com.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestDBservlet")
public class TestDBservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = "user";
		String password = "pass";
		//url
		String dburl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		try {
			
			PrintWriter out = response.getWriter();
			out.println("Coneecting to DB: " + dburl);
			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(dburl,user,password);
			out.println("Success!");
			myConn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		}
		
	}
}
