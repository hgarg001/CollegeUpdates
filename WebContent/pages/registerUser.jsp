<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
<head>
<title>TODO supply a title</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript">
	function matchPassword() {
		var pass1 = document.getElementById("password1").value;
		var pass2 = document.getElementById("password2").value;
		if (pass1 == pass2) {
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<body>
	<div style="text-align: center;">
		<h1>Register user</h1>
		<br> <br>
		<%
			String message = "";

			if (request.getQueryString() != null) {
				message = request.getParameter("message");
			}
		%>
		<p><%=message%></p>
		<div style="margin-left: 37%;">
			<form action="../UserServlet" method="post">
				<table border="0" style="text-align: left;">
					<tr>
						<td>Registration number:</td>
						<td><input name="userId" type="text" required="true"></td>
					</tr>
					<tr>
						<td>User Name:</td>
						<td><input name="userName" type="text" required="true">
						</td>
					</tr>
					<tr>
						<td>Gender:</td>
						<td><input name="gender" type="radio" value="M">Male
							<input name="gender" type="radio" value="F">Female</td>
					</tr>
					<tr>
						<td>Date of birth:</td>
						<td><input name="dateOfBirth" type="date" required="true"></td>
					</tr>
					<tr>
						<td>Branch:</td>
						<td><input name="branch" type="text" required="true"></td>
					</tr>
					<tr>
						<td>Department:</td>
						<td><input name="department" type="text" required="true">
						</td>
					</tr>
					<tr>
						<td>Email Id:</td>
						<td><input name="emailId" type="email" required="true"></td>
					</tr>
					<tr>
						<td>Mobile number:</td>
						<td><input name="mobileNumber" type="number" required="true"></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input id="password1" name="password" type="password"
							required="true"></td>
					</tr>
					<tr>
						<td>Confirm password:</td>
						<td><input id="password2" name="conpassword" type="password"
							required="true"></td>
					</tr>
					<tr>
						<td style="text-align: right;"><input type="reset"></td>
						<td style="text-align: right;"><input type="submit"
							name="submit" value="Register" onclick="return matchPassword()"></td>
					</tr>
					<tr>
						<td colspan="2">Already registered for login click <a
							href="login.jsp">here</a><br></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>

