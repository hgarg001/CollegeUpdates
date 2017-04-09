<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collection"%>
<%@page import="servlet.PostServlet"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="service.PostService"%>
<%@page import="models.Post"%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
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
		<br> <br>
		<div>
			<%
				final String userId = "DFGDFG";
				List<Post> allPosts = new ArrayList<Post>();
				List<Long> likedPostIds = new ArrayList<Long>();
				allPosts = new PostService().getAllPost();
				likedPostIds = new PostService().likedPost(userId);
				Iterator<Post> itr = allPosts.iterator();

				int count = 0;
				int noOfPostToShow = PostServlet.postCount * 5;
				while (itr.hasNext() && count < noOfPostToShow) {
					Post post = itr.next();
			%>
			<table border="1" style="width: 388pt;">
				<tr>
					<td rowspan="2" style="height: 45px; width: 50px;">pic</td>
					<td><%=post.getPostOwnerId()%></td>
				</tr>
				<tr>
					<td><%=post.getPostDateTime().toLocalTime()%><span> </span><%=post.getPostDateTime().toLocalDate()%></td>
				</tr>
				<tr>
					<td colspan="2"><%=post.getPostText()%></td>
				</tr>
				<tr>
					<td colspan="2">
						<%
							String path = "../PostServlet?postId=" + post.getPostId() + "";
						%>
						<form action=<%=path%> method="post">

							<%
								if (!likedPostIds.contains(post.getPostId())) {
							%>
							<span><input name="submit" type="submit" value="Like">
								<%
									} else if (likedPostIds.contains(post.getPostId())) {
								%> <input name="submit" type="submit" value="Unlike"> <%
 	}
 		String noOfLike = "";
 		if (post.getNoOfLikes() > 0) {
 			noOfLike += post.getNoOfLikes();
 		}
 %> <%=noOfLike%></span>
						</form>
					</td>
				</tr>
			</table>
			<br>
			<%
				count++;
				}
				if (count < allPosts.size()) {
			%>
			<form action="../PostServlet" method="post">
				<span><input name="submit" type="submit" value="More Stroies"></span>
			</form>
			<%
				}
			%>
			<br>
		</div>
	</div>
</body>
</html>