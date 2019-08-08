package com.text;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginDemo extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String name=req.getParameter("name");
		//String password=req.getParameter("password");
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","namrata","12345");
			PreparedStatement ps=con.prepareStatement("Select * from employee15 where name=? ");
			ps.setString(1,name);
			
			ResultSet rs=ps.executeQuery();
			pw.print("<html><table border=2><tr><td>username</td><td>password</td></tr>");
			
			
			while(rs.next())
			{
				pw.print("<tr><td>"+rs.getString(1)+"</td>"+"  "+"<td>"+rs.getString(2)+"</td></tr>");
			}
			
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}
}
