<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr>
	<c:choose>
		<c:when test="${empty LOGIN_USER}">
			<a href="${pageContext.request.contextPath}/loginForm">로그인</a>
		</c:when>
		<c:otherwise>
			<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
		</c:otherwise>
	</c:choose>
	<a href="${pageContext.request.contextPath}/list">자유게시판</a>
	<hr>
</body>
</html>