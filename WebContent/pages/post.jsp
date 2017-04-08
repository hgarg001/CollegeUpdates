<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function validatePost() {
		var postText = document.getElementById("postData").value;
		if (postText != "") {
			return true;
		}
		return false;
	}
</script>
</head>
<body>
	<div style="margin-left: 30%;">
		<div>
			<form action="../PostServlet" method="post">
				<table border="0" style="text-align: left;">
					<tr>
						<td><textarea id="postData" cols="70" rows="7"
								name="postText"></textarea></td>
					</tr>
					<tr>
						<td><input name="submit" type="submit" value="Post"
							onclick="return validatePost()"></td>
					</tr>
				</table>
			</form>
		</div>
		<div>
			<%
				for (int i = 0; i < 5; i++) {
			%>
			<table border="1" style="width: 388pt;">
				<tr>
					<td rowspan="2" style="height: 45px; width: 50px;">pic</td>
					<td>hello</td>
				</tr>
				<tr>
					<td>hello</td>
				</tr>
				<tr>
					<td colspan="2">Hello</td>
				</tr>
				<tr>
					<td colspan="2">
						<form action="../PostServlet" method="post">
							<input name="submit" type="submit" value="Like">
						</form>
					</td>
				</tr>
			</table>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>