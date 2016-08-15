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
	<form action='${pageContext.request.contextPath}/write' method='POST' encType="multipart/form-data">
		제목 : <input type='text' size='30' name='title'/><br>
		글쓴이 : <input type='text' name='writer'/><br>
		내용 : <textarea rows='10' cols='50' name='content'/></textarea><br>
		첨부파일 : <input type="file" name="attachFile" /><br>
	<button type='submit'>등록</button>
	</form>
	</div>
	<div class="footer">
		<%@ include file="/include/bottom.jsp" %>
	</div>
</div>
</body>
</html>