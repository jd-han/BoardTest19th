<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>네트워크게시판</title>
</head>
<body>
<div class="container">
	<div class="header">
		<%@ include file="/include/topMenu.jsp" %>
	</div>	
	<div class="content">
	
	<hr>
	<h2>자바 네트워크 게시판</h2>
	<hr>
	<form action='${pageContext.request.contextPath}/update' method='POST'>
		제목 : <input type='text' size='30' name='title' value='${board.title}'/><br>
		글쓴이 : <input type='text' name='writer' readonly='readonly' value='${board.writer}'/><br>
		내용 : <textarea rows='10' cols='50' name='content'>${board.content}</textarea><br>
	<input type='hidden' name='no' value='${board.no}'/>
	<button type='submit'>수정</button>
	</form>
	</div>
	<div class="footer">
		<%@ include file="/include/bottom.jsp" %>
	</div>
</div>
</body>
</html>