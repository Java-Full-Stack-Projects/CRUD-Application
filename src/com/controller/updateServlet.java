package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.registerDao;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateServlet() {
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
		String name=request.getParameter("custname");
		int custId=Integer.parseInt(request.getParameter("custid"));
		try {
			if(custId<=0)
			{
				throw new Exception();
			}
		} catch (Exception ex) {
			pw.print("<script>alert('Enter Valid customer ID');location='update.jsp'; </script>");
		}
		int i=rd.searchId(custId);
		if(i==1)
		{
			i=rd.updatecustomer(custId, name);
			if(i>0)
			{
				String str="Customer Name Updated Successfully";
				session.setAttribute("updmsg", str);
				response.sendRedirect("update.jsp");
			}
			
		}
		if(i==0)
		{
			pw.print("<script>alert('customer Does Not Exist');</script>");
			RequestDispatcher rds=request.getRequestDispatcher("update.jsp");
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