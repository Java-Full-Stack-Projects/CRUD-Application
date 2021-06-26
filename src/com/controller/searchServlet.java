package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.registerDao;
import com.model.customer;


/**
 * Servlet implementation class searchServlet
 */
@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		registerDao rd=new registerDao();
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession();
		int custId=Integer.parseInt(request.getParameter("custid"));
		try {
			if(custId<=0)
			{
				throw new Exception();
			}
		} catch (Exception ex) {
			pw.print("<script>alert('Enter Valid customer ID');location='search.jsp'; </script>");
		}
		int i=rd.searchId(custId);
		if(i==1)
		{
			try {
				ResultSet rs=rd.searchCustomer(custId);
				rs.next();
				customer c=new customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				session.setAttribute("customer", c);
				response.sendRedirect("search.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(i==0)
		{
			pw.print("<script>alert('customer Does Not Exist');</script>");
			RequestDispatcher rds=request.getRequestDispatcher("search.jsp");
			rds.include(request, response);
			return;
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