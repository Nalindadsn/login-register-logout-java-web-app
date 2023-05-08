package com.uniquedeveloper.registration;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
/**
 * Servlet implementation class Search
 */
@WebServlet("/search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	   public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	    {
	        response.setContentType ("text/html");
	        PrintWriter out = response.getWriter ();
	        String femail = request.getParameter ("femail");
	        try
	        {
	            Class.forName ("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/youtube", "root", "");
	            PreparedStatement ps =
	         con.prepareStatement ("select * from feedback where uemail=?");
	            ps.setString (1, femail);
	            out.print ("<html><head><link href='css/index-styles.css' rel='stylesheet' /></head><body>"
	            		+ ""
	            		+ "<nav\r\n"
	            		+ "		class='navbar navbar-expand-lg bg-secondary text-uppercase fixed-top'\r\n"
	            		+ "		id='mainNav'>\r\n"
	            		+ "		<div class='container'>index.jsp\r\n"
	            		+ "			<a class='navbar-brand' href='#page-top'>DOC</a>\r\n"
	            		+ "			<button\r\n"
	            		+ "				class='navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded'\r\n"
	            		+ "				type='button' data-bs-toggle='collapse'\r\n"
	            		+ "				data-bs-target='#navbarResponsive' aria-controls='navbarResponsive'\r\n"
	            		+ "				aria-expanded='false' aria-label='Toggle navigation'>\r\n"
	            		+ "				Menu <i class='fas fa-bars'></i>\r\n"
	            		+ "			</button>\r\n"
	            		+ "			<div class='collapse navbar-collapse' id='navbarResponsive'>\r\n"
	            		+ "				<ul class='navbar-nav ms-auto'>\r\n"
	            		+ "					<li class='nav-item mx-0 mx-lg-1'><a\r\n"
	            		+ "						class='nav-link py-3 px-0 px-lg-3 rounded' href='feedback.jsp'>Add New Feedback</a></li>\r\n"
	            		+ "				\r\n"
	            		+ "					\r\n"
	            		+ "					\r\n"
	            		+ "				</ul>\r\n"
	            		+ "			</div>\r\n"
	            		+ "		</div>\r\n"
	            		+ "	</nav>"
	            		+ ""
	            		+ ""
	            		+ "<table class='table mt-10' style='margin-top:100px' width=100% border=1>");
	            out.print ("<caption>Feedback Details:" +femail+"</caption>");
	            ResultSet rs = ps.executeQuery ();
	            /* Printing column names */
	            out.print ("</br></br>");
	            ResultSetMetaData rsmd = rs.getMetaData ();
	            int total = rsmd.getColumnCount ();
	            out.print ("<tr>");
	            for (int i = 1; i <= total; i++)
	         {
	             out.print ("<th>" + rsmd.getColumnName (i) + "</th>");
	         }
	            out.print ("</tr>");
	            /* Printing result */
	            while (rs.next ())
	         {
	             out.print ("<tr><td>" + rs.getString (1) + "</td><td>" +  rs.getString (2) + " </td><td>" + rs.getString (3) + "</td><td>" + rs.getString (4) + "</td><td>" + rs.getString (5) + "</td><td>" + rs.getString (6) + "</td></tr>");
	         }
	            out.print ("</table></body></html>");
	        }
	        catch (Exception e2)
	        {
	            e2.printStackTrace ();
	        }
	        finally
	        {
	            out.close ();
	        }
	    }

}
