package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.registerDao;
import com.model.customer;


/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public  boolean isValid(String mobNo)
	{

		// The given argument to compile() method
		// is regular expression. With the help of
		// regular expression we can validate mobile
		// number.
		// 1) Begins with 0 or 91
		// 2) Then contains 7 or 8 or 9.
		// 3) Then contains 9 digits
		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");

		// Pattern class contains matcher() method
		// to find matching between given number
		// and regular expression
		Matcher m = p.matcher(mobNo);
		return (m.find() && m.group().equals(mobNo));
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		registerDao rd = new registerDao();
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession();
		int flag=0;
		
		int custId=Integer.parseInt(request.getParameter("custid"));
		try {
			if(custId<=0)
			{
				throw new Exception();
			}
		} catch (Exception ex) {
			pw.print("<script>alert('Enter Valid customer ID');location='register.jsp'; </script>");
		}
		
		ResultSet rs=rd.validateID();
		try {
			while(rs.next())
			{
				if(rs.getInt(1)==custId)
				{
					pw.print("<script>alert('Enter Unique customer ID');location='register.jsp'; </script>");
					flag=1;
					//	response.sendRedirect("register.html");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag==0)
		{
			String custname=request.getParameter("custname");
			String email=request.getParameter("email");
			String mobno=request.getParameter("mobno");
			String city=request.getParameter("city");
			String state=request.getParameter("state");
			if(isValid(mobno))
			{
				customer c=new customer(custId, custname, mobno, email, city, state);
				int i=rd.createUser(c);
				if(i>0)
				{
					String str="Customer Registered Successfullyy";
					session.setAttribute("msg", str);
					response.sendRedirect("register.jsp");

				}
			}
			else
			{
				pw.print("<script> if(confirm('Enter valid Mobile Number')){window.location.href='register.jsp'} </script>");
				
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}