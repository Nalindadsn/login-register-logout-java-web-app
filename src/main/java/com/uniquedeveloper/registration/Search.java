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
	        String empid = request.getParameter ("empid");
	        try
	        {
	            Class.forName ("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/youtube", "root", "");
	            PreparedStatement ps =
	         con.prepareStatement ("select * from feedback where uemail=?");
	            ps.setString (1, empid);
	            out.print ("<table width=50% border=1>");
	            out.print ("<caption>Employee Details:</caption>");
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
	            out.print ("</table>");
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
