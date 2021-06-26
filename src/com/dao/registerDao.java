package com.dao;

import java.sql.*;

import com.model.customer;

public class registerDao {

	int i=0;
	public int createUser(customer c)
	{
		Connection con = dbConnection.getConnection();

		try {
			PreparedStatement pstate=con.prepareStatement("insert into customer values(?,?,?,?,?,?)");
			pstate.setInt(1, c.getCustid());
			pstate.setString(2, c.getCustname());
			pstate.setString(3, c.getEmail());
			pstate.setString(4, c.getMobno());
			pstate.setString(5, c.getCity());
			pstate.setString(6, c.getState());
			i=pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public ResultSet validateID()
	{
		Connection con = dbConnection.getConnection();
		if(con != null) {
		System.out.println("successfully connected..");
		}
		else {
			System.out.println("not connected...");
		}
		
		ResultSet rs = null;
		try {
			Statement st = con.createStatement(); 
	        rs = st.executeQuery("select * from customer");  
	        System.out.println(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public int searchId(int eid)
	{
		Connection con=dbConnection.getConnection();
		try {
			PreparedStatement pstate=con.prepareStatement("select *from customer where custid=?");
			pstate.setInt(1, eid);
			ResultSet rs=pstate.executeQuery();
			if(rs.next())
			{
				i=1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public ResultSet searchCustomer(int eid)
	{
		ResultSet rs=null;
		Connection con=dbConnection.getConnection();
		try {
			PreparedStatement pstate=con.prepareStatement("select *from customer where custid=?");
			pstate.setInt(1, eid);
			rs=pstate.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public int deleteCustomer(int eid)
	{
		Connection con=dbConnection.getConnection();
		try {
			PreparedStatement pstate=con.prepareStatement("delete from customer where custid=?");
			pstate.setInt(1, eid);
			i=pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public int updatecustomer(int eid,String name)
	{
		Connection con=dbConnection.getConnection();
		try {
			PreparedStatement pstate=con.prepareStatement("update customer set custname=? where custid=?");
			pstate.setString(1, name);
			pstate.setInt(2, eid);
			i=pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public ResultSet displayCustomer()
	{
		Connection con=dbConnection.getConnection();
		String str="select *from customer";
		ResultSet rs=null;
		try {
			Statement st=con.createStatement();
			rs = st.executeQuery(str);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}
