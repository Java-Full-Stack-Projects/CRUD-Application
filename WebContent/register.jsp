<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="navbar.css">
<title>Register</title>
</head>
<%! String str=null; %>
<body  style="background-image: linear-gradient(to right top, #b4cd5a, #c1c647, #cebd34, #dcb422, #eba912); background-repeat: no-repeat; background-attachment: fixed; background-size: cover;">
	<div class="container">
		<div class="row mt-5">
			<div class="col-md-4 offset-md-4">
			<%
				if(!session.isNew())
				{
					str=(String)session.getAttribute("msg");
					out.print("<center><h3 style='color: green;'>");
					out.print(str);
					out.print("</center></h3>");
				}
			session.invalidate();
			%>
				<div class="card">
					<div class="card-header text-center c-head">
						<i class="fa fa-user-circle" style="font-size: 48px;"></i>
						<h5>Registration</h5>
					</div>
					<div class="card-body">

						<form action="registerServlet" method="post">
							<div class="form-group">

								<div class="form-group">
									<label for="exampleInputEmail1">Customer ID</label> <input
										type="text" class="form-control" id="exampleInputEmail1"
										aria-describedby="emailHelp" name="custid" required="required">
								</div>

								<div class="form-group">
									<label for="exampleInputEmail1">Customer Name</label> <input
										type="text" class="form-control" id="exampleInputEmail1"
										aria-describedby="emailHelp" name="custname"
										required="required">
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Email ID</label> <input
										type="email" class="form-control" id="exampleInputEmail1"
										aria-describedby="emailHelp" name="email" required="required">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Mobile Number</label> <input
										type="number" class="form-control" id="exampleInputPassword1"
										name="mobno" required="required">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">City</label> <input
										type="text" class="form-control" id="exampleInputPassword1"
										name="city" required="required">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">State</label> <input
										type="text" class="form-control" id="exampleInputPassword1"
										name="state" required="required">
								</div>
								<button type="submit"
									class="btn btn-primary btn-block badge-pill">Register</button>
									<button type="submit"
									class="btn btn-primary btn-block badge-pill" onclick="window.location.href='index.html'">Home</button>
						</form>
					</div>
				</div>
			</div>
		</div>
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