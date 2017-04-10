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
	function validate() {
		var userId = document.getElementById("userId").value;
		var password = document.getElementById("password").value;
		if (userId == null || password == null) {
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body>
	<div style="text-align: center;">
		<h1>Login</h1>
		
		
		<% String message="";
		
		if(request.getQueryString()!=null){
			message=request.getParameter("message");
		}
		
		%>
			<p><%=message %></p>
			<div style="margin-left: 37%;">
			<form action="../UserServlet" method="post">
				<table border="0" style="text-align: left;">
					<tr>
						<td>Registration number:</td>
						<td><input id="userId" name="userId" type="text"
							required="true"></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input id="password" name="password" type="password"
							required="true"></td>
					</tr>
					<tr>
						<td style="text-align: right;"><input type="submit"
							name="submit" value="Login" onclick="return validate()"></td>
					</tr>
					<tr>
						<td colspan="2">New user for register click <a
							href="registerUser.jsp">here</a><br></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>

