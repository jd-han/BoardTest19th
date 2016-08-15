<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>네트워크게시판</title>
</head>

<div class="container">
	<div class="header">
		<%@ include file="/include/topMenu.jsp" %>
	</div>	
	<div class="content">
	<hr>
	<h2>자바 네트워크 게시판</h2>
	<hr>
	전체 <c:out value="${fn:length(list)}" />개
	<table width='80%' border='1'>
		<tr>
		<th>번호</th>
		<th>제목</th>
		<th>글쓴이</th>
		<th>등록일</th>
		</tr>
		<tr>
		</tr>
		<c:forEach var="board" items="${list}">
			<tr>
			<td><c:out value="${board.no}" /></td>
			<td><a href='detail?no=<c:out value="${board.no}" />'><c:out value="${board.title}" /></a></td>
			<td><c:out value="${board.writer}" /></td>
			<td>
				<fmt:formatDate var="regDate" value="${board.regDate}" pattern="yyyy-MM-dd"/>
				<c:out value="${regDate}" />
			</td>
			</tr>
		</c:forEach>
		<c:if test="${empty list}">
			<tr><td colspan='4'>게시물이 존재하지 않습니다.</td></tr>
		</c:if>
		</table>
		<a href='${pageContext.request.contextPath}/writeForm'>글쓰기</a>
	</div>
	<div class="footer">
		<%@ include file="/include/bottom.jsp" %>
	</div>
</div>


<body>
</body>
</html>