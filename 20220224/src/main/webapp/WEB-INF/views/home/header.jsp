<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/menu.css">
</head>
<body>
	<div align="center">
		<div>
			<br />
		</div>
		<div>
			<!-- 메뉴부분 -->
			<ul>
				<li><a class="active" href="home.do">Home</a></li>
				<c:if test="${empty id }">
					<li><a href=loginForm.do>Login</a>
				</c:if>
				<c:if test="${not empty id }">
					<li><a href="Logout.do">LogOut</a>
				</c:if>
				<li><a href="#">Contact</a></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Product</a></li>
				<c:if test="${empty id} }">
					<li><a href></a></li>
				</c:if>
				<li><a href="#"></a></li>
				<li><a href="memberList.do">Members</a></li>
			</ul>
		</div>
	</div>
</body>
</html>