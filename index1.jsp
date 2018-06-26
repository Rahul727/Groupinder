<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

</head>

<body>

	<form action="LoginServlet" align="right" method="post">
		<input type="text" placeholder="Email" name="email" size="20">
		<input type="password" placeholder="Passcode" name="passcode"
			size="10"> <input id="login" type="submit" value="Login">
	</form>

	<div>

		<form action="RegisterServlet" align="left" method ="post">
			<fieldset>
				<legend>Registration </legend>
				<h2>
					Name: <input type="text" id="email" name="name" size="20">
					<br> Email: <input type="text" name="email" size="20">
					<br> Password: <input type="password" name="password" size="10"> <br>
					Retype password: &nbsp; <input type="password" name="password_retyped" size="10"> <br>
					Phone number: <input type="text" size="3" name="phone_number_country_code"> 
					<input type="text" size="10" name="phone_number_main">
					<br>Captcha: <br> <br> 
					<input id="register" type="submit" value="Note It !">
				</h2>
			</fieldset>
		</form>
<% Object registration_done = session.getAttribute("login_now");
   if(registration_done != null){
				out.print(registration_done);
				session.invalidate();
				}else{
		 		out.print("");
		 		}
	
 %>

	</div>

	<jsp:include page="footer.jsp" />

</body>

</html>

