package com.uniquedeveloper.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Feedback
 */
@WebServlet("/feedback")
public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub



		 
RequestDispatcher dispatcher=null;
Connection con=null;
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dms","root","");
	PreparedStatement pst=con.prepareStatement("select * from feedback");
		
	ResultSet rs=pst.executeQuery();



	if (rs.next()){
		dispatcher=request.getRequestDispatcher("index.jsp");

	}else {

		request.setAttribute("status", "failed");
		dispatcher=request.getRequestDispatcher("login.jsp");
	}
	dispatcher.forward(request, response);
}catch(Exception e) {
	e.printStackTrace();
	
	
}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		 String uname=request.getParameter("name");
		 String uemail=request.getParameter("email");
		 String umobile=request.getParameter("contact");
		 String message=request.getParameter("message");
RequestDispatcher dispatcher=null;
Connection con=null;
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dms","root","");
	

	 PreparedStatement pst=con.prepareStatement("insert into feedback(uname,uemail,umobile,message) values(?,?,?,?)");
	pst.setString(1, uname);
	pst.setString(2, uemail);
	pst.setString(3, umobile);
	pst.setString(4, message);
	int rowCount=pst.executeUpdate();
	dispatcher=request.getRequestDispatcher("feedback.jsp");
	if (rowCount>0){
		request.setAttribute("status", "success");
	}else {

		request.setAttribute("status", "failed");
	}

		
	 
	 
	dispatcher.forward(request, response);
}catch(Exception e) {
	e.printStackTrace();
	
	
}finally {
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	
	}

}
