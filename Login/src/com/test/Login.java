package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		
		if(pass.equals("virtusa"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("welcome.jsp");
			rd.include(req,res);
		}
		else
		{
			pw.print("Enter valid username and password");
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.include(req,res);
			
		}
	}
}
