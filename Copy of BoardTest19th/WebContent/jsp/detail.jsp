<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<br>
	<br>
	<hr>
	번호 : <c:out value="${board.no}" /><br>
	글쓴이 : <c:out value="${board.writer}" /><br>
	제목 : <c:out value="${board.title}" /><br>
	내용 : <c:out value="${board.content}" /><br>
	<fmt:formatDate var="regDate" value="${board.regDate}" pattern="yyyy-MM-dd HH:mm:ss" />
	등록일시 : <c:out value="${regDate}" /><br>
	첨부파일 : 
	<a href="${pageContext.request.contextPath}/down?path=${file.filePath}&realName=${file.realFileName}&oriName=${file.oriFileName}">${file.oriFileName}</a>(${file.fileSize} byte)
	<hr>
	<form action="${pageContext.request.contextPath}/comment" method="post">
		<input type="hidden" name="no" value="${board.no}">
		<input type="hidden" name="writer" value="${LOGIN_USER.id}">
		댓글 : <input type="text" name="content">
		<button type="submit">등록</button>
	</form>
	<hr>
	<%--댓글 목록 --%>
	<table border="1px">
		<tr>
			<th width="10%">댓글번호</th>
			<th width="10%">글쓴이</th>
			<th width="50%">내용</th>
			<th width="20%">등록일</th>
			<th width="10%"></th>
		</tr>
			<c:choose>
				<c:when test="${empty commentList}">
					<td colspan="5">댓글이 없습니다.</td>
				</c:when>
				<c:otherwise>
					<c:forEach var="comment" items="${commentList}">
					<tr>
						<td><c:out value="${comment.commentNo}"/></td>
						<td><c:out value="${comment.writer}"/></td>
						<td><c:out value="${comment.content}"/></td>
						<td>
							<fmt:formatDate var="cmtRegDate" value="${comment.regDate}" pattern="yyyy-MM-dd HH:mm:ss" />
							<c:out value="${cmtRegDate}"/>
						</td>
						<td>
							<c:if test="${LOGIN_USER.id eq comment.writer}">
								<a href="${pageContext.request.contextPath}/updateCommentForm?commentNo=${comment.commentNo}&no=${comment.no}">수정</a>
								<a href="${pageContext.request.contextPath}/deleteComment?commentNo=${comment.commentNo}&no=${comment.no}">삭제</a>
							</c:if>
						</td>
					</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
	</table>
	<hr>
	<a href='${pageContext.request.contextPath}/updateForm?no=<c:out value="${board.no}" />'>수정</a><a href='${pageContext.request.contextPath}/delete?no=<c:out value="${board.no}" />'>삭제</a><a href='${pageContext.request.contextPath}/list'>목록</a>
	</div>
	<div class="footer">
		<%@ include file="/include/bottom.jsp" %>
	</div>
</div>
</body>
</html>