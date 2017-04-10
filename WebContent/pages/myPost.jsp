<%@page import="java.util.Collections"%>
<%@page import="java.time.format.FormatStyle"%>
<%@page import="java.time.temporal.ChronoUnit"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="servlet.PostServlet"%>
<%@page import="java.time.LocalTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="service.PostService"%>
<%@page import="models.Post"%>
<%@page import="java.util.ArrayList"%>
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

<div>

<div >

<table  border="1" style="text-align: left;" width="100px;">

<tr>
<td style="height: 30px; width: 50px;" >
<a href="post.jsp">Home</a>
</td>
</tr>
<tr>
<td style="height: 30px; width: 50px;" >
<a href="myPost.jsp">My Post</a>
</td>
</tr>
<tr>
<td style="height: 30px; width: 50px;" >
<a href="../index.html">Logout</a>
</td>

</tr>

</table>

</div>

</div>

	<div style="margin-left: 30%;">

		<div>
			<%
					final String userId = "DFGDFG";
					List<Post> allUserPosts = new ArrayList<Post>();
					List<Long> likedPostIds = new ArrayList<Long>();
					allUserPosts = new PostService().getAllUserPost(userId);
					
					Collections.sort(allUserPosts, Post.postIdComparator);
					
					likedPostIds = new PostService().likedPost(userId);
					Iterator<Post> itr = allUserPosts.iterator();

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

					<%
						LocalDate postDate=post.getPostDateTime().toLocalDate();
							   LocalTime postTime=post.getPostDateTime().toLocalTime();
							   LocalDate todayDate=LocalDate.now();
							   LocalTime todayTime=LocalTime.now();
							   String path = "../PostServlet?postId=" + post.getPostId() + "";
							   
							   String postTimeString="";
							   String postDateString="";
							   
							   if((postTime.getHour()==todayTime.getHour() && postTime.getMinute()==todayTime.getMinute()) && postDate.equals(todayDate)){
								   postTimeString="Just Now";
								   postDateString="";
							   }else if(postDate.isEqual(todayDate)){
								   postDateString="Today";
								   
								   if(postTime.getHour()-todayTime.getHour()==0){
									   postTimeString=(todayTime.getMinute() - postTime.getMinute())+" min ago";
									   postDateString="";
								   }
								  
								   if(postTime.getHour()-todayTime.getHour()<0){
									   
									    postTimeString=postTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)).toString();
									    postDateString="Today";		   
									   
								   }
								 
							   }else if(postDate.getYear()==todayDate.getYear()){
								   DateTimeFormatter dfmt = DateTimeFormatter.ofPattern("dd MMM");

								     postTimeString=postTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)).toString();
								     postDateString=postDate.format(dfmt);
								     
							   }else {
								   DateTimeFormatter dfmt = DateTimeFormatter.ofPattern("dd MMM yyyy");

								   	 postTimeString=postTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)).toString();
							   	   	 postDateString=postDate.format(dfmt);
							   }
					%>
					<td><%=postTimeString%><span> </span><%=postDateString%></td>
				</tr>
				<tr>
					<td colspan="2"><%=post.getPostText()%></td>
				</tr>
				<tr>
					<td colspan="2">
						<%
							
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
 %> <%=noOfLike%> 			<input name="submit" type="submit" value="Delete">
 </span>
						</form>
					</td>
				</tr>
			</table>
			<br>
			<%
				count++;
					}
					if (count < allUserPosts.size()) {
			%>
			
			<form action="../PostServlet" method="post">
				<span><input name="submit" type="submit" value="See More"></span>
			</form>
			<%
				}
			%>
			<br>
		</div>
	</div>
</body>
</html>