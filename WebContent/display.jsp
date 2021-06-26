<%@page import="com.model.customer"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="navbar.css">
<link rel='stylesheet' type='text/css' href="mystyle.css">
</head>
<%!List<customer> custlist; %>
<body  style="background-image: linear-gradient(to right top, #b4cd5a, #c1c647, #cebd34, #dcb422, #eba912); background-repeat: no-repeat; background-attachment: fixed; background-size: cover;">
	<div class="container">
		<div class="row mt-5">
			<div class="col-md-4 offset-md-4">
			<div class="card">
					<div class="card-header text-center c-head">
						<i class="fa fa-user-circle" style="font-size: 48px;"></i>
						<h5>Display Customers</h5>
					</div>
					<div class="card-body">

						<form action="displayServlet" method="post">
								<button type="submit"
									class="btn btn-primary btn-block badge-pill">Display</button>
									<button type="reset"
									class="btn btn-primary btn-block badge-pill" onclick="window.location.href='index.html'">Home</button>
								</form>
					</div>
				</div>
			</div>
		</div>
<%
	if(!session.isNew())
	{
		custlist=(List<customer>)session.getAttribute("list");
%>	
		<h3><center>Customer Details</center></h3>
		<table id='cust'>
		<tr><th>Customer ID</th><th>Customer Name</th><th>email</th><th>Mobile No</th><th>City</th><th>State</th></tr>
		<%for(customer c:custlist)
		{
		%>
			<tr><td><%=c.getCustid() %></td><td><%=c.getCustname() %></td><td><%= c.getEmail()%></td><td><%=c.getMobno() %></td><td><%=c.getCity() %></td><td><%=c.getState() %></td></tr>
			
		<%
		}
		%>
		</table>
<% 
	}
session.invalidate();
%>
		
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>