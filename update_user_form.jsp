<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.bean.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update User</title>
</head>
<body>
<% User user =(User) session.getAttribute("currentUser"); %>
<form action="UpdateUserServlet" method="post">
<div class="form-group">
					<input type="text" class="form-control" name="name" placeholder="<%=user.user_name%>" value="<%=user.user_name%>"required>
				</div>
				<div class="form-group">
					<input type="email" name="email" class="form-control" placeholder="<%=user.email%>" required>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" name="password"	placeholder="Password" required>
				</div>
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">+1</span>
					<input type="text" class="form-control" placeholder="<%=user.phone_number_main%>" value="<%=user.phone_number_main%>" aria-describedby="basic-addon1" id="mobile" name="phone_number_main" required>
				</div> 
				
					<input type="submit">
</form>
</body>
</html>