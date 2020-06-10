<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
<c:import url="../template/nav.jsp"></c:import>

<div class="container">
	<h1>SELECT PAGE</h1>
	<h3>Title: ${vo.title}</h3>
	<h3>Writer: ${vo.writer}</h3>
	<h3>Contents: ${vo.contents}</h3>
	<a href="${board}Update?num=${vo.num}" class="btn btn-primary">Update</a>
	<a href="${board}Delete?num=${vo.num}" class="btn btn-danger">Delete</a>
	<c:if test="${board eq 'qna'}">
		<a href="${board}Reply?num=${vo.num}" class="btn btn-primary">Reply</a>
	</c:if>
</div>

</body>
</html>