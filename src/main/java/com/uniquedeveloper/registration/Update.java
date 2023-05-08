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
 * Servlet implementation class Update
 */
@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 HttpSession session=request.getSession();
		// TODO Auto-generated method stub
		 String uname=request.getParameter("name");
		 String uemail=request.getParameter("email");
		 String upwd=request.getParameter("pass");
		 String umobile=request.getParameter("contact");
RequestDispatcher dispatcher=null;
Connection con=null;
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube","root","");
	

	 if(upwd=="") {
		 PreparedStatement pst=con.prepareStatement("UPDATE users SET uname =?,  umobile = ? WHERE uemail = ?");
			pst.setString(1, uname);
			pst.setString(2, umobile);
			pst.setString(3, uemail);
			int rowCount=pst.executeUpdate();

			dispatcher=request.getRequestDispatcher("update.jsp");
			if (rowCount>0){
				request.setAttribute("status", "success");

				session.setAttribute("name",uname);
				session.setAttribute("mobile",umobile);
			}else {

				request.setAttribute("status", "failed");
			}
			dispatcher=request.getRequestDispatcher("update.jsp");
	 }else {
		 PreparedStatement pst=con.prepareStatement("UPDATE users SET uname =?, upwd = ?, umobile = ? WHERE uemail = ?");
			pst.setString(1, uname);
			pst.setString(2, upwd);
			pst.setString(3, umobile);
			pst.setString(4, uemail);
			int rowCount=pst.executeUpdate();
			

			dispatcher=request.getRequestDispatcher("update.jsp");
			if (rowCount>0){
				request.setAttribute("status", "success");
				session.setAttribute("name",uname);
				session.setAttribute("mobile",umobile);
			}else {

				request.setAttribute("status", "failed");
			}

			dispatcher=request.getRequestDispatcher("update.jsp");
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
